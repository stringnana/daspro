import java.util.Scanner;
public class TambahMatriks
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		Matriks[] dimension = new Matriks[2];
		System.out.println("Penjumlahan Matriks Ordo 2x2");
		System.out.println();
		for(int i=0;i<dimension.length;i++)
		{
			Matriks mat = new Matriks();
			System.out.println("Masukan Matriks ke-"+(i+1));
			for(int j = 0;j < mat.getBaris();j++)
			{
				String snilai = input.nextLine();
				String anilai[] = snilai.split(" ");
				int nilai[] = new int[anilai.length];
				for(int k = 0;k < anilai.length;k++)
				{
					nilai[k] = Integer.parseInt(anilai[k]);
					mat.setMatriks(j, k, nilai[k]);
				}
			}
			dimension[i] = mat;
			System.out.println();
		}
		System.out.println("Hasil Penjumlahan Matriks");
		jumlahMatriks(dimension[0], dimension[1]);
	}
	public static void jumlahMatriks(Matriks matriks1, Matriks matriks2)
	{
		Matriks matriks = new Matriks();
		for(int i=0;i<matriks1.getBaris();i++)
		{
			for(int j=0;j<matriks1.getKolom();j++)
			{
				matriks.setMatriks(i, j, (matriks1.getMatriks(i, j)+matriks2.getMatriks(i, j)));
			}
		}
		for(int i=0;i<matriks.getBaris();i++)
		{
			for(int j=0;j<matriks.getKolom();j++)
			{
				System.out.print(matriks.getMatriks(i, j)+" ");
			}
			System.out.println();
		}
	}
}
class Matriks
{
	private int[][] matriks = new int[2][2];
	public void setMatriks(int baris, int kolom, int nilai)
	{
		this.matriks[baris][kolom] = nilai;
	}
	public int getMatriks(int baris, int kolom)
	{
		return this.matriks[baris][kolom];
	}
	public int getBaris()
	{
		return this.matriks.length;
	}
	public int getKolom()
	{
		return this.matriks[0].length;
	}
}