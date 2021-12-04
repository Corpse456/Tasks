package fifteen.one;

public class Main {

    private final static int MIN = 3;
    private final static int MAX = 9;

    private static int[][] board;
    private static int[] board2;

    // размер игрового поля
    private static int d;

    public static void main(String[] args) throws InterruptedException {
	// Убедиться в наличие единственного аргумента
	if (args.length != 1) {
	    System.out.println("Usage: fifteen d");
	    System.exit(0);
	}

	// убедиться что аргумент - число в пределах от 3 до 9 включительно
	try {
	    d = Integer.parseInt(args[0]);
	} catch (NumberFormatException e) {
	    System.out.println("Agrument must be a number");
	    System.exit(0);
	}
	if (d < MIN || d > MAX) {
	    System.out.printf("Board must be between %d x %d and %d x %d, inclusive.\n", MIN, MIN, MAX,
		    MAX);
	    System.exit(0);
	}

	// Приветствие и инструкции
	greet();

	// Инициализация игрового поля
	init();

	// играть до побеы или запроса выхода
	while (true) {
	    // Отрисовать текущее положение на игровом поле
	    draw();

	    // Проверка, не собрано ли поле
	    if (won()) {
		System.out.println("You won!!!");
		break;
	    }

	    // Запрос следующего хода
	    System.out.printf("Tile to move: ");
	    int tile;
	    try {
		tile = GetInput.get();
	    } catch (GodException e) {
		godMode();
		break;
	    }

	    // Сделать ход, если возможно, иначе - сообщить об ошибке
	    if (!move(tile)) {
		System.out.println("\nIllegal move.");
		Thread.sleep(1000);
	    }

	    // Задержка вывода
	    Thread.sleep(300);
	}
    }

    /**
     * Greets player.
     * 
     * @throws InterruptedException
     */
    private static void greet() throws InterruptedException {
	System.out.println("\t\t\tWELCOME TO GAME OF FIFTEEN!");
	System.out.println("If you want to move tile, please input the number written on it");
	try {
	    GetInput.get();
	} catch (GodException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	// Thread.sleep(2000);
    }

    /**
     * Initializes the game's board with tiles numbered 1 through d*d - 1 (i.e.,
     * fills 2D array with values but does not actually print them).
     */
    private static void init() {
	board = new int[d][d];
	board2 = new int[d * d];
	int number = d * d - 1;

	board2[number] = 0;
	for (int i = 0; i < d; i++) {
	    for (int j = 0; j < d; j++) {
		if (number == 0)
		    break;
		board[i][j] = number;
		board2[number - 1] = number--;
	    }
	}
	if ((d * d) % 2 == 0) {
	    int change = board[d - 1][d - 3];
	    board[d - 1][d - 3] = board[d - 1][d - 2];
	    board[d - 1][d - 2] = change;
	}
	swap();
    }

    private static void swap() {
	for (int i = 0; i < 1000; i++) {
	    for (int j = 0; j < 1000; j++) {
		int rand = (int) (Math.random() * d);
		int rand2 = (int) (Math.random() * d);
		move(board[rand][rand2]);
	    }
	}
    }

    /**
     * Prints the board in its current state.
     */
    private static void draw() {
	for (int i = 0; i < d; i++) {
	    for (int k = 0; k <= d - 1; k++) {
		System.out.print("-----");
	    }
	    System.out.println("-");
	    for (int j = 0; j < d; j++) {
		if (board[i][j] == 0) {
		    System.out.print("|    ");
		} else {
		    System.out.print("| " + (board[i][j] > 9 ? board[i][j] : " " + board[i][j]) + " ");
		}
	    }
	    System.out.println("|");
	}
	for (int k = 0; k <= d - 1; k++) {
	    System.out.printf("-----");
	}
	System.out.println("-");
    }

    /**
     * If tile borders empty space, moves tile and returns true, else returns
     * false.
     */
    private static boolean move(int tile) {
	for (int i = 0; i < d; i++) {
	    for (int j = 0; j < d; j++) {
		if (board[i][j] == tile) {
		    if ((i + 1 != d) && (board[i + 1][j] == 0)) {
			change(i, j, i + 1, j);
			return true;
		    } else if ((i - 1 != -1) && (board[i - 1][j] == 0)) {
			change(i, j, i - 1, j);
			return true;
		    } else if ((j + 1 != d) && (board[i][j + 1] == 0)) {
			change(i, j, i, j + 1);
			return true;
		    } else if ((j - 1 != -1) && (board[i][j - 1] == 0)) {
			change(i, j, i, j - 1);
			return true;
		    } else {
			return false;
		    }
		}
	    }
	}
	return false;
    }

    /**
     * Returns true if game is won (i.e., board is in winning configuration),
     * else false.
     */
    private static boolean won() {
	int min = 0;
	for (int i = 0; i < d; i++) {
	    for (int j = 0; j < d; j++) {
		if (board[i][j] == board2[min]) {
		    min++;
		} else
		    return false;
	    }
	}
	return true;
    }

    private static void change(int i, int j, int k, int m) {
	int change = board[i][j];
	board[i][j] = board[k][m];
	board[k][m] = change;
    }

    private static void godMode() throws InterruptedException {
	int min = 0, k = 0, m = 0, counter = 0;
	while (!won()) {
	    for (int i = 0; i < d; i++) {
		for (int j = 0; j < d; j++) {
		    if (board[i][j] == board2[min]) {
			if (i == k && j == m) {
			    min++;
			    m++;
			    if (m == d) {
				k++;
				m = 0;
			    }
			    if (k == d - 2 || k == d - 1) {
				counter++;
			    }
			    if (k == d - 2 && counter % 2 != 0 && m != d - 1) {
				k = d - 1;
				m = m % d;
				min += d;
				continue;
			    }
			    if (k == d - 1 && counter % 2 == 0) {
				k = d - 2;
				m--;
				min = min - 1 - d;
				continue;
			    }
			    continue;
			}
			for (int x = 0; x < d; x++) {
			    for (int y = 0; y < d; y++) {
				if (board[x][y] == 0) {
				    if (i == k && j > m) {
					if (x > i && (y == j || y > j)) {
					    if (k == d - 2 && i == k && j == m + 1 && y == j) {
						step(board[x][y + 1]);
					    } else if (k == d - 2 && i == k && j == m + 1 && y > j) {
						step(board[x-- - 1][y]);
						step(board[x][y-- - 1]);
						step(board[x][y-- - 1]);
						step(board[x++ + 1][y]);
						step(board[x][y++ + 1]);
						step(board[x-- - 1][y]);
						step(board[x][y++ + 1]);
						step(board[x++ + 1][y]);
						step(board[x][y-- - 1]);
						step(board[x][y-- - 1]);
						step(board[x-- - 1][y]);
						step(board[x][y + 1]); // стрёмный
								       // момент
					    } else {
						step(board[x][y - 1]); // стрёмный
								       // момент
					    }
					} else if (x > i && y < j) {
					    if (y == j - 1) {
						step(board[x - 1][y]);
					    }
					    step(board[x][y + 1]);
					} else if (x == i && y < j) {
					    step(board[x][y + 1]);
					} else if (x == i && y > j) {
					    if (x == d - 1) {
						step(board[x - 1][y]);
					    } else {
						step(board[x + 1][y]);
					    }
					} else if (x < i && y >= j) {
					    step(board[x][y - 1]);
					} else if (x < i && y < j) {
					    step(board[x + 1][y]);
					}
				    } else if (i > k && j == m) {
					if (x < i && y == j) {
					    step(board[x + 1][y]);
					} else if (x < i && y > j) {
					    step(board[x][y - 1]);
					} else if (x < i && y < j) {
					    step(board[x][y + 1]);
					} else if (x > i && y == j) {
					    if (x == k + 2 && y == d - 1) {
						step(board[x - 1][y]);
						x -= 1;
						step(board[x - 1][y]);
						x -= 1;
						step(board[x][y - 1]);
						y -= 1;
						step(board[x + 1][y]);
						x += 1;
						step(board[x][y + 1]);
						y += 1;
						step(board[x + 1][y]);
						x += 1;
						step(board[x][y - 1]);
						y -= 1;
						step(board[x - 1][y]);
						x -= 1;
						step(board[x - 1][y]);
						x -= 1;
						step(board[x][y + 1]);
						y += 1;
						step(board[x + 1][y]);
					    }
					    if (y == d - 1) {
						step(board[x][y - 1]);
					    } else {
						step(board[x][y + 1]);
					    }
					} else if (x >= i && (y > j || y < j)) {
					    if (i == k + 1 && j == m && j == y + 1) {
						if (x == i) {
						    step(board[x + 1][y]);
						}
						if (x > i) {
						    step(board[x][y + 1]);
						}
					    }
					    step(board[x - 1][y]);
					}
				    } else if (i > k && j < m) {
					if (x > i && y > j) {
					    step(board[x - 1][y]);
					} else if (x == i && y > j) {
					    step(board[x][y - 1]);
					} else if (x == i && y < j) {
					    if (x == d - 1) {
						step(board[x - 1][y]);
					    } else {
						step(board[x + 1][y]);
					    }
					} else if ((x > i || x < i) && y <= j) {
					    step(board[x][y + 1]);
					} else if (x < i && y > j) {
					    step(board[x + 1][y]);
					} else if (x < i && y <= j) {
					    step(board[x][y + 1]);
					}
				    } else if (i > k && j > m) {
					if (x >= i && y > j) {
					    step(board[x - 1][y]);
					}
					if (x == i && y < j) {
					    step(board[x][y + 1]);
					} else if (x < i && y > j) {
					    step(board[x][y - 1]);
					} else if (x < i && y < j) {
					    step(board[x][y + 1]);
					} else if (x < i && y == j) {
					    step(board[x + 1][y]);
					} else if (x > i && y == j) {
					    if (y == d - 1) {
						step(board[x][y - 1]);
					    } else {
						step(board[x][y + 1]);
					    }
					} else if (x > i && y < j) {
					    step(board[x - 1][y]);
					}
				    } else if (i < k && j > m) {
					if (x == i && y > j) {
					    if (i == k + 1 && j == m + 1 && y == j + 1) {
						step(board[x][y - 1]);
						y -= 1;
						step(board[x][y - 1]);
						y -= 1;
						step(board[x + 1][y]);
						x += 1;
						step(board[x][y + 1]);
						y += 1;
						step(board[x][x - 1]);
						x -= 1;
						step(board[x][y + 1]);
						y += 1;
						step(board[x][x + 1]);
						x += 1;
						step(board[y - 1][y]);
						y -= 1;
						step(board[y - 1][y]);
						y -= 1;
						step(board[x][x - 1]);
						x -= 1;
						step(board[y + 1][y]);
					    }
					    step(board[x + 1][y]);
					} else if (x == i && y < j) {
					    step(board[x][y + 1]);
					} else if (x > i && y >= j) {
					    step(board[x][y - 1]);
					} else if (x > i && y < j) {
					    step(board[x - 1][y]);
					}
				    } else if (i < k && j == m) {
					if (x == i && y > j) {
					    step(board[x + 1][y]);
					} else if (x > i && y > j) {
					    step(board[x][y - 1]);
					} else if (x > i && y == j) {
					    step(board[x - 1][y]);
					}
				    }
				}
			    }
			}
		    }
		}
	    }
	}
	System.out.println("\nthank you for using our God-mode ;-)");
    }

    private static void step(int shift) throws InterruptedException {
	int sleep = 2000;
	move(shift);
	sleep /= d * d / 1.5;
	Thread.sleep(sleep);
	draw();
    }
}