package programmers.해시.방문길이;

import java.util.HashSet;

/**
 * 4차원 배열을 이용해서 풀 수도 있는 문제
 */

class Solution {
    static int x = 0;
    static int y = 0;

    public int solution(String dirs) {
        HashSet<Path> set = new HashSet<>();

        for (char c : dirs.toCharArray()) {
            int nextX = x;
            int nextY = y;

            if (c == 'U') {
                if (y < 5) {
                    nextY = y + 1;
                }
            } else if (c == 'D') {
                if (y > -5) {
                    nextY = y - 1;
                }
            } else if (c == 'L') {
                if (x > -5) {
                    nextX = x - 1;
                }
            } else if (c == 'R') {
                if (x < 5) {
                    nextX = x + 1;
                }
            }

            if (nextX != x || nextY != y) {
                Path newPath = new Path(x, y, nextX, nextY);
                if (!containsSimilarPath(set, newPath)) {
                    set.add(newPath);
                }
                x = nextX;
                y = nextY;
            }
        }

        return set.size();
    }

    private boolean containsSimilarPath(HashSet<Path> set, Path newPath) {
        for (Path path : set) {
            if (path.isSimilar(newPath)) {
                return true;
            }
        }
        return false;
    }
}

class Path {
    int prevX;
    int prevY;
    int nowX;
    int nowY;

    Path(int prevX, int prevY, int nowX, int nowY) {
        this.prevX = prevX;
        this.prevY = prevY;
        this.nowX = nowX;
        this.nowY = nowY;
    }

    public boolean isSimilar(Path other) {
        return (this.prevX == other.prevX && this.prevY == other.prevY && this.nowX == other.nowX && this.nowY == other.nowY)
                || (this.prevX == other.nowX && this.prevY == other.nowY && this.nowX == other.prevX && this.nowY == other.prevY);
    }
}
