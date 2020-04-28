import java.util.Scanner;

public class Maze {
	static int i = 0,j = 0;
	//走迷宮迴圈
	public static boolean walk(int[][] a,int n){
		//找路--右
		if(j+1 <= n-1&&a[i][j+1] == 1){
				a[i][j] = 2;
				j++;
			}
		//找路--下
		else if(i+1 <= n-1&&a[i+1][j] == 1){
				a[i][j] = 2;
				i++;
			}
		//找路--左
		else if(j-1 >= 0&&a[i][j-1] == 1){
				a[i][j] = 2;
				j--;
			}
		//找路--上
		else if(i-1 >= 0&&a[i-1][j] == 1){
				a[i][j] = 2;
				i--;
			}
		//找不到路
		else{
			//在起點--判斷為找不到出口
			if(i == 0&&j == 0)
				return false;
			//往回走--右
			if(j+1 <= n-1&&a[i][j+1] == 2){
					a[i][j] = 0;
					j++;
				}
			//往回走--下
			else if(i+1 <= n-1&&a[i+1][j] == 2){
					a[i][j] = 0;
					i++;
				}
			//往回走--左
			else if(j-1 >= 0&&a[i][j-1] == 2){
					a[i][j] = 0;
					j--;
				}
			//往回走--上
			else if(i-1 >= 0&&a[i-1][j] == 2){
					a[i][j] = 0;
					i--;
				}
		}
		//走到出口
		if(i == n-1&&j == n-1)
			return true;
		//繼續跑迴圈
		else
			return walk(a,n);
	}
	public static void main(String[] args){
	int n;//長寬
	Scanner sc = new Scanner(System.in);
	System.out.println("輸入迷宮的長寬N: ");
	n = sc.nextInt();
	int a[][] = new int[n][n];//迷宮
	System.out.println("輸入迷宮矩陣:");
	for(int i = 0;i < n;i++)
		for(int j = 0;j < n;j++)
			a[i][j] = sc.nextInt();
	//起點或終點為0
	if(a[0][0] == 0||a[n-1][n-1] == 0||!walk(a,n))
		System.out.println("走不到出口QQ~");
	else
		System.out.println("走的到出口~");
	sc.close();
	}
}
