import java.text.DecimalFormat;
import java.util.Scanner;

public class Koga
{
	public static void main(String args[])
	{
		System.out.println();
		System.out.println("======================================================");
		System.out.println(" Komposisi Gaya");
		System.out.println("======================================================");
		System.out.println();
		
		Scanner data = new Scanner(System.in);
		
		System.out.println("Masukan data yang didapat saat praktikum");
		System.out.println("Pisahkan data dengan spasi dan pastikan jumlah data sama");
		System.out.println();
		
		System.out.print("m1   => ");
		String sm1 = data.nextLine();
		System.out.print("m2   => ");
		String sm2 = data.nextLine();
		System.out.print("Fres => ");
		String sfres = data.nextLine();
		System.out.print("a1   => ");
		String sa1 = data.nextLine();
		System.out.print("a2   => ");
		String sa2 = data.nextLine();
		
		/* data yang di dapat saat praktikum
		double m1[] = {0.150, 0.150, 0.150, 0.100, 0.100, 0.050};
		double m2[] = {0.050, 0.100, 0.150, 0.200, 0.050, 0.050};
		double fres[] = {0.9, 1.8, 2.2, 2.4, 1.0, 0.5};
		double a1[] = {77, 66, 55, 46, 66, 65};
		double a2[] = {41, 50, 55, 66, 48, 50};*/

		String am1[] = sm1.split(" ");
		String am2[] = sm2.split(" ");
		String afres[] = sfres.split(" ");
		String aa1[] = sa1.split(" ");
		String aa2[] = sa2.split(" ");
		
		double m1[] = new double[am1.length];
		double m2[] = new double[am2.length];
		double fres[] = new double[afres.length];
		double a1[] = new double[aa1.length];
		double a2[] = new double[aa2.length];
		
		for(int i=0;i<am1.length;i++)
		{
			m1[i] = Double.parseDouble(am1[i]);
			m2[i] = Double.parseDouble(am2[i]);
			fres[i] = Double.parseDouble(afres[i]);
			a1[i] = Double.parseDouble(aa1[i]);
			a2[i] = Double.parseDouble(aa2[i]);
		}
		
		// konstanta nilai gravitasi
		double g = 9.8;
		
		// jumlah data yang dimasukan
		int n = m1.length;
		
		// variable yang akan d pass by reference
		double f1[] = new double[n];
		double f2[] = new double[n];
		double sina1[] = new double[n];
		double sina2[] = new double[n];
		double cosa1[] = new double[n];
		double cosa2[] = new double[n];
		double ftheori[] = new double[n];
		
		// untuk sigma fres dan ftheori
		double Efres = 0.0;
		double Eftheori = 0.0;
		
		for(int i=0;i<n;i++)
		{
			f1[i] = m1[i]*g;
			f2[i] = m2[i]*g;
			sina1[i] = trigono("sin", a1[i]);
			sina2[i] = trigono("sin", a2[i]);
			cosa1[i] = trigono("cos", a1[i]);
			cosa2[i] = trigono("cos", a2[i]);
		}
		
		System.out.println();
		System.out.println(" Tabel 1. Data yang diapat saat Praktikum");
		
		System.out.println("-----------------------------------------------");
		System.out.printf("| %1s | %-6s | %-6s | %-7s | %-5s | %-5s |%n", "N", "m1(kg)", "m2(kg)", "Fres(N)", "a1", "a2");
		System.out.println("-----------------------------------------------");

		for(int i=0;i<n;i++)
		{
			System.out.printf("| %1s | %-6s | %-6s | %-7s | %-5s | %-5s |%n", i+1, m1[i], m2[i], fres[i], a1[i], a2[i]);
		}

		System.out.println("-----------------------------------------------");
		System.out.println();
		
		System.out.println(" Rumus");
		System.out.println(" -----");
		System.out.println(" F1 = m1.g");
		System.out.println(" F2 = m2.g");
		System.out.println(" F3 = F1/F2");
		System.out.println(" a1 = sin a1");
		System.out.println(" a2 = sin a2");
		System.out.println(" a3 = sin a2/sin a1");
		
		System.out.println();
		System.out.println(" Tabel 2. Perhitungan");
		
		System.out.println("-------------------------------------------------------");
		System.out.printf("| %1s | %-5s | %-5s | %-5s | %-6s | %-6s | %-6s |%n", "N", "F1(N)", "F2(N)", "F3", "sin a1", "sin a2", "sin a3");
		System.out.println("-------------------------------------------------------");

		for(int i=0;i<n;i++)
		{
			double f3 = f1[i]/f2[i];
			double a3 = sina2[i]/sina1[i];
			System.out.printf("| %1s | %-5.2f | %-5.2f | %-5.2f | %-6.2f | %-6.2f | %-6.2f |%n", i+1, f1[i], f2[i], f3, sina1[i], sina2[i], a3);
		}

		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		System.out.println(" =======");
		System.out.println(" Ftheori");
		System.out.println(" =======");
		System.out.println(" Rumus");
		System.out.println(" ------");
		System.out.println(" Ftheori = F1 Cos a1 + F2 Cos a2");
		System.out.println(" -------------------------------");
		System.out.println(" Perhitungan");
		System.out.println(" -----------");

		for(int i=0;i<n;i++)
		{	
			double hasil1 = f1[i]*cosa1[i];
			double hasil2 = f2[i]*cosa2[i];
			double hasil3 = hasil1+hasil2;
			System.out.println(" Ftheori"+(i+1)+" = "+bulatkan(f1[i])+" x "+bulatkan(cosa1[i])+" + "+bulatkan(f2[i])+" x "+bulatkan(cosa2[i]));
			System.out.println("          = "+bulatkan(hasil1)+" + "+bulatkan(hasil2));
			System.out.println("          = "+bulatkan(hasil3));
			ftheori[i] = hasil3;
			
			Efres += fres[i];
			Eftheori += ftheori[i];
		}
		
		System.out.println();
		System.out.println(" Tabel 3. Hasil");
		
		System.out.println("---------------------------------");
		System.out.printf("| %1s | %-6s | %-6s | %-7s |%n", "N", "cos a1", "cos a2", "Ftheori");
		System.out.println("---------------------------------");
		
		for(int i=0;i<n;i++)
		{
			System.out.printf("| %1s | %-6s | %-6s | %-7s |%n", i+1, bulatkan(cosa1[i]), bulatkan(cosa2[i]), bulatkan(ftheori[i]));
		}
		
		System.out.println("---------------------------------");
		
		System.out.println();
		System.out.println(" Sigma Hasil");
		System.out.println(" -----------");
		System.out.println(" EFres = "+bulatkan(Efres));
		System.out.println(" EFtheori = "+bulatkan(Eftheori));
	}
	
	public static double trigono(String tipe, double sudut)
	{
		double hasil = 0.0;
		if(tipe.equals("sin"))
			hasil = Math.sin(Math.toRadians(sudut));
		if(tipe.equals("cos"))
			hasil = Math.cos(Math.toRadians(sudut));
		return hasil;
	}
	
	public static String bulatkan(double angka)
	{
		return String.format("%.2f", angka);
	}
}
