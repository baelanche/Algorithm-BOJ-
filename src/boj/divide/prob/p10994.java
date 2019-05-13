package boj.divide.prob;

import java.util.Scanner;

public class p10994 {

static char a[][];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int len = 1;
        for(int i=1; i<n; i++) len += 4;
        a = new char[len][len];
        
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                a[i][j] = ' ';
            }
        }
        
        drawStar(0, len);
        
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void drawStar(int s, int len) {
        for(int i=s; i<len; i++) {
            a[s][i] = '*'; //�� �� ������
            a[len-1][i] = '*'; //�� �Ʒ� ������
            a[i][s] = '*'; //���� ������
            a[i][len-1] = '*'; //������ ������
        }
        
        if(len == 1) return;
        
        drawStar(s+2, len-2);
    }
}
