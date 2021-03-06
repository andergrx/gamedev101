package com.gabe.uyen.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.gabe.uyen.game.entity.mob.Player;
import com.gabe.uyen.game.graphics.Screen;
import com.gabe.uyen.game.input.Keyboard;
import com.gabe.uyen.game.input.Mouse;
import com.gabe.uyen.game.level.Level;
import com.gabe.uyen.game.level.TileCoordinate;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private static int width = 300;
	private static int height = width / 16 * 9;
	private static int scale = 3;
	public static String title = "GabeUyen";

	private Thread gameThread;
	private JFrame frame;

	private boolean running = false;

	private Screen screen;
	private Keyboard key;
	private Level level;
	private Player player;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		level = Level.spawn;
		TileCoordinate playerSpawn = new TileCoordinate(20, 67);
		player = new Player(playerSpawn.getX(), playerSpawn.getY(), key);
		player.init(level);

		Mouse mouse = new Mouse();
		addKeyListener(key);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}

	public static int getWindowWidth() {
		return width * scale;
	}

	public static int getWindowHeight() {
		return height * scale;
	}

	public synchronized void start() {
		running = true;
		gameThread = new Thread(this, "Display");
		gameThread.start();

	}

	public synchronized void stop() {
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0, updates = 0;

		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				update();
				++updates;
				--delta;
			}
			render();
			++frames;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += (System.currentTimeMillis() - timer);
				// System.out.println(updates + " ups, " + frames + " fps");
				frame.setTitle(title + ": " + updates + " ups, " + frames + " fps");
				updates = frames = 0;
			}
		}
		stop();
	}

	public void update() {
		level.update();
		key.update();
		player.update();

	}

	public void render() {
		BufferStrategy bstrat = getBufferStrategy();
		if (bstrat == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);

		System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);

		Graphics g = bstrat.getDrawGraphics();

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 50));
		//g.fillRect(Mouse.getX() - 32, Mouse.getY() - 32, 64, 64);
		//if (Mouse.getButton() != -1) g.drawString("Button: " + Mouse.getButton(), 80, 80);
		g.dispose();
		bstrat.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("GabeUyen");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}

}
