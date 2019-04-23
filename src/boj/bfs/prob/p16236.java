package boj.bfs.prob;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p16236 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        
        int x = 0, y = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] == 9) {
                    x = i;
                    y = j;
                }
            }
        }
        //ó�� ��ġ ����
        
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, -1, 0, 1};
        int size = 2; //�Ʊ� ����� ó�� ũ��
        int eat = 0; //����� ��Ƹ��� Ƚ��
        int time = 0; //�� ��� �ð�
        while(true) {
            Queue<Shark> q = new LinkedList<Shark>(); //BFS �� ť
            ArrayList<Shark> fish = new ArrayList<Shark>(); //��Ƹ��� ����⸦ ������ ����Ʈ
            boolean visited[][] = new boolean[n][n]; //�湮 ���(�ݺ����� �����ϱ� ���� �ʿ�)
            
            q.offer(new Shark(x, y, 0));
            visited[x][y] = true;
            
            int find = -1; //����⸦ �ϳ��� �߰����� ���ߴٸ� ������Ű�� ����
            while(!q.isEmpty()) {
                Shark shark = q.poll();
                int sx = shark.x;
                int sy = shark.y;
                int move = shark.move;
                
                if(find == move) break; //�Ʒ� �������� ����⸦ �Ծ��ٸ� BFS�� �����Ų��
                
                for(int i=0; i<4; i++) {
                    int nx = sx + dx[i];
                    int ny = sy + dy[i];
                    if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if(a[nx][ny] <= size && !visited[nx][ny]) {
                            if(0 < a[nx][ny] && a[nx][ny] < size) {
                                find = move + 1; //�Ծ��ٸ� find ������ �̵��Ÿ��� ����
                                fish.add(new Shark(nx, ny, move + 1)); //���� ����� ����Ʈ�� �߰�
                            }
                            q.offer(new Shark(nx, ny, move + 1)); //BFS ť�� �߰�
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            
            if(find == -1) break; //���� ����Ⱑ ���ٸ� ������ �����Ų��
            else {
                Shark f = fish.get(0);
                for(int i=1; i<fish.size(); i++) {
                    if(f.x > fish.get(i).x) {
                        f = fish.get(i);
                        continue;
                    } else if(f.x == fish.get(i).x) {
                        if(f.y > fish.get(i).y) {
                            f = fish.get(i);
                        }
                    }
                }
                //��Ƹ��� ����Ⱑ ����������� �� -> ���� ����⸦ �켱���� �԰���

                time += find; //����ð� ������ �̵��Ÿ��� �����ش�
                a[x][y] = 0; //ó�� �Ʊ����� ��ġ �ʱ�ȭ
                a[f.x][f.y] = 9; //�ٽ� BFS�� ���� ��ġ�� ����⸦ ��Ƹ��� ��ġ�� ������
                x = f.x;
                y = f.y;
                if(size == ++eat) {
                    size++;
                    eat = 0;
                }
                //����� ũ�Ⱑ ��Ƹ��� Ƚ���� ���ٸ� ũ�⸦ Ű���
            }
        }
        System.out.println(time);
    }
    
    static class Shark {
        int x;
        int y;
        int move;
        
        Shark(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
}
