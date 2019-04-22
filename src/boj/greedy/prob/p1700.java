package boj.greedy.prob;

import java.util.Scanner;

public class p1700 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[k];
        int c[] = new int[n];
        for(int i=0; i<k; i++)
            a[i] = sc.nextInt();
        
        int cnt = 0;
        for(int i=0; i<k; i++) {
            for(int j=0; j<n; j++) {
                if(c[j] == 0) {
                    //�÷��׿� �ƹ��͵� �� �����ִٸ�
                    connectFlug(a[i], j, c);
                    //a[i]�� �ȴ´�
                } else {
                    //�÷��׿� �̹� �����ִٸ�
                    cnt += disconnectFlug(a, i, c);
                    //�ٸ� �÷��װ� ����ִ���, ���� ������� ���� Ȯ�� �� �÷��׸� �̴´�
                    connectFlug(a[i], j, c);
                    //a[i]�� �ȴ´�
                }
            }
        }
        System.out.println(cnt);
    }
    
    public static void connectFlug(int input, int tap, int[] c) {
        for(int i=0; i<c.length; i++) {
            if(c[i] == input) return;
            //���� ��Ⱑ �̹� �ִٸ� ���� �ʴ´�
        }
        if(c[tap] == 0) c[tap] = input;
        //����ִٸ� �ȴ´�
    }
    
    public static int disconnectFlug(int[] a, int input, int[] c) {
        for(int i=0; i<c.length; i++) {
            if(c[i] == 0) return 0; //����ִٸ� ���� �� ����
            if(c[i] == a[input]) return 0; //��������� ���� �ʴ´�
        }
        
        int temp[] = new int[c.length];
        for(int l=0; l<temp.length; l++) {
            for(int i=input+1; i<a.length; i++) {
                if(a[i] == c[l]) {
                    temp[l] = i;
                    break;
                    //���� �÷��װ� ������ ���°�� ���Ǵ��� üũ�Ѵ�
                }
            }
        }
        
        int max = 0;
        int idx = 0;
        for(int i=0; i<temp.length; i++) {
            if(temp[i] == 0) {
                //���Ŀ� ������ �÷����� ��
                idx = i;
                break;
            }
            if(temp[i] > max) {
                //temp �迭�� ���Ͽ� ���� �������� ������ ����� �÷��׸� �̴´�
                max = temp[i];
                idx = i;
            }
        }
        c[idx] = 0; //�÷��׸� �̴´�
        
        return 1;
    }
}
