import java.util.Scanner;

public class Maze {
	static int i = 0,j = 0;
	//���g�c�j��
	public static boolean walk(int[][] a,int n){
		//���--�k
		if(j+1 <= n-1&&a[i][j+1] == 1){
				a[i][j] = 2;
				j++;
			}
		//���--�U
		else if(i+1 <= n-1&&a[i+1][j] == 1){
				a[i][j] = 2;
				i++;
			}
		//���--��
		else if(j-1 >= 0&&a[i][j-1] == 1){
				a[i][j] = 2;
				j--;
			}
		//���--�W
		else if(i-1 >= 0&&a[i-1][j] == 1){
				a[i][j] = 2;
				i--;
			}
		//�䤣���
		else{
			//�b�_�I--�P�_���䤣��X�f
			if(i == 0&&j == 0)
				return false;
			//���^��--�k
			if(j+1 <= n-1&&a[i][j+1] == 2){
					a[i][j] = 0;
					j++;
				}
			//���^��--�U
			else if(i+1 <= n-1&&a[i+1][j] == 2){
					a[i][j] = 0;
					i++;
				}
			//���^��--��
			else if(j-1 >= 0&&a[i][j-1] == 2){
					a[i][j] = 0;
					j--;
				}
			//���^��--�W
			else if(i-1 >= 0&&a[i-1][j] == 2){
					a[i][j] = 0;
					i--;
				}
		}
		//����X�f
		if(i == n-1&&j == n-1)
			return true;
		//�~��]�j��
		else
			return walk(a,n);
	}
	public static void main(String[] args){
	int n;//���e
	Scanner sc = new Scanner(System.in);
	System.out.println("��J�g�c�����eN: ");
	n = sc.nextInt();
	int a[][] = new int[n][n];//�g�c
	System.out.println("��J�g�c�x�}:");
	for(int i = 0;i < n;i++)
		for(int j = 0;j < n;j++)
			a[i][j] = sc.nextInt();
	//�_�I�β��I��0
	if(a[0][0] == 0||a[n-1][n-1] == 0||!walk(a,n))
		System.out.println("������X�fQQ~");
	else
		System.out.println("������X�f~");
	sc.close();
	}
}
