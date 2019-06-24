public class Spiralizor {
    private enum Direction {
        STOP,
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    public static int[][] spiralize(int size) {
        int[][] result = new int[size][size];
        int n = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = 1;
            }
        }
        if (size == 2) {
            result[1][0] = 0;
        }
        if (size > 2) {
            Direction direction = Direction.RIGHT;
            int i = 1;
            int j = 0;
            result[i][j] = 0;
            while (!direction.equals(Direction.STOP)) {
                switch (direction) {
                    case UP:
                    case DOWN:
                        direction = goY(result, i, j, direction);
                        break;
                    case LEFT:
                    case RIGHT:
                        direction = goX(result, i, j, direction);
                        break;
                }
                switch (direction) {
                    case LEFT:
                        j--;
                        break;
                    case RIGHT:
                        j++;
                        break;
                    case UP:
                        i--;
                        break;
                    case DOWN:
                        i++;
                        break;
                }
                if (i == 3 && j == 5) {
                    System.out.println();
                }
                if (!direction.equals(Direction.STOP)) {
                    result[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        return result;
    }

    public static Direction goY(int[][] a, int i, int j, Direction dir) {
        Direction direction = null;
        if (j == a.length - 2) {
            if (dir.equals(Direction.DOWN)) {
                if (i == a.length - 2) {
                    if (verifyNeighbors(a, i, j - 1, Direction.LEFT)) {
                        direction = Direction.LEFT;
                    } else {
                        direction = Direction.STOP;
                    }
                } else {
                    direction = Direction.DOWN;
                }
            } else {
                throw new RuntimeException("Incorrect direction");
            }
        } else if (j == 1) {
            if (dir.equals(Direction.UP)) {
                if (i == 3) {
                    if (verifyNeighbors(a, i, j + 1, Direction.RIGHT)) {
                        direction = Direction.RIGHT;
                    } else {
                        direction = Direction.STOP;
                    }
                } else {
                    direction = Direction.UP;
                }
            } else {
                throw new RuntimeException("Incorrect direction");
            }
        } else {
            switch (dir) {
                case RIGHT:
                case LEFT:
                case STOP:
                    throw new RuntimeException("Incorrect direction");
                case UP:
                    if (verifyNeighbors(a, i - 1, j, Direction.UP)) {
                        direction = Direction.UP;
                        break;
                    }
                    if (verifyNeighbors(a, i, j - 1, Direction.LEFT)) {
                        direction = Direction.LEFT;
                        break;
                    }
                    if (verifyNeighbors(a, i, j + 1, Direction.RIGHT)) {
                        direction = Direction.RIGHT;
                        break;
                    }
                    direction = Direction.STOP;
                    break;
                case DOWN:
                    if (verifyNeighbors(a, i + 1, j, Direction.DOWN)) {
                        direction = Direction.DOWN;
                        break;
                    }
                    if (verifyNeighbors(a, i, j - 1, Direction.LEFT)) {
                        direction = Direction.LEFT;
                        break;
                    }
                    if (verifyNeighbors(a, i, j + 1, Direction.RIGHT)) {
                        direction = Direction.RIGHT;
                        break;
                    }
                    direction = Direction.STOP;
                    break;
            }
        }
        return direction;
    }

    public static Direction goX(int[][] a, int i, int j, Direction dir) {
        Direction direction = null;
        if (i == 1) {
            if (dir.equals(Direction.RIGHT)) {
                if (j == a.length - 2) {
                    if (verifyNeighbors(a, i + 1, j, Direction.DOWN)) {
                        direction = Direction.DOWN;
                    } else {
                        direction = Direction.STOP;
                    }
                } else {
                    direction = Direction.RIGHT;
                }
            } else {
                throw new RuntimeException("Incorrect direction");
            }
        } else if (i == a.length - 2) {
            if (dir.equals(Direction.LEFT)) {
                if (j == 1) {
                    if (verifyNeighbors(a, i - 1, j, Direction.UP)) {
                        direction = Direction.UP;
                    } else {
                        direction = Direction.STOP;
                    }
                } else {
                    direction = Direction.LEFT;
                }
            } else {
                throw new RuntimeException("Incorrect direction");
            }
        } else {
            switch (dir) {
                case UP:
                case DOWN:
                case STOP:
                    throw new RuntimeException("Incorrect direction");
                case RIGHT:
                    if (verifyNeighbors(a, i, j + 1, Direction.RIGHT)) {
                        direction = Direction.RIGHT;
                        break;
                    }
                    if (verifyNeighbors(a, i - 1, j, Direction.UP)) {
                        direction = Direction.UP;
                        break;
                    }
                    if (verifyNeighbors(a, i + 1, j, Direction.DOWN)) {
                        direction = Direction.DOWN;
                        break;
                    }
                    direction = Direction.STOP;
                    break;
                case LEFT:
                    if (verifyNeighbors(a, i, j - 1, Direction.LEFT)) {
                        direction = Direction.LEFT;
                        break;
                    }
                    if (verifyNeighbors(a, i - 1, j, Direction.UP)) {
                        direction = Direction.UP;
                        break;
                    }
                    if (verifyNeighbors(a, i + 1, j, Direction.DOWN)) {
                        direction = Direction.DOWN;
                        break;
                    }
                    direction = Direction.STOP;
                    break;
            }
        }
        return direction;
    }

    public static boolean verifyNeighbors(int[][] a, int i, int j, Direction direction) {
        boolean result = false;
        try {
            switch (direction) {
                case STOP:
                    throw new RuntimeException("Incorrect direction");
                case LEFT:
                    result = a[i][j - 1] != 0 && a[i + 1][j - 1] != 0 && a[i - 1][j - 1] != 0;
                    break;
                case RIGHT:
                    result = a[i][j + 1] != 0 && a[i + 1][j + 1] != 0 && a[i - 1][j + 1] != 0;
                    break;
                case UP:
                    result = a[i - 1][j] != 0 && a[i - 1][j - 1] != 0 && a[i - 1][j + 1] != 0;
                    break;
                case DOWN:
                    result = a[i + 1][j] != 0 && a[i + 1][j - 1] != 0 && a[i + 1][j + 1] != 0;
                    break;
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return result;
    }
}
