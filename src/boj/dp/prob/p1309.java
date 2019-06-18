package boj.dp.prob;

import java.util.Scanner;

public class p1309 {

	static int N;
    static int dp[][] = new int[100001][3];
    
    /* status
     * 0 : ���� �迭�� ��ġ ����
     * 1 : ���� �迭 ������ ��ġ
     * 2 : ���� �迭 ������ ��ġ
     */
    public static int lion(int n, int status) {
        if(n == N) return 1;
        if(dp[n][status] != -1) return dp[n][status];
        
        int ret = lion(n+1, 0) % 9901;
        if(status != 1) ret += lion(n+1, 1) % 9901;
        if(status != 2) ret += lion(n+1, 2) % 9901;
        dp[n][status] = ret;
        return ret;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        for(int i=0; i<=N; i++)
            for(int j=0; j<3; j++)
                dp[i][j] = -1;
        
        System.out.println(lion(0, 0) % 9901);
    }
}
