package paket;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Pisti_game {

	

	public static void main(String[] args) {
		
		
		//TANIMLAMALAR
		String[] SiraliDeste = new String[52];
		int[] SiraliDesteDegeri = new int[52];
		String[] KarisikDeste = new String[52];
		int[] KarisikDesteDegeri = new int[52];
		String[] YerdekiKagitlar = new String[52];
		int[] YerdekiKagitlardegeri = new int[52];
		String[] PcEli = new String[4];
		int[] PcEliDegeri = new int[4];
		String[] OyuncuEli = new String[4];
		int[] OyuncuEliDegeri = new int[4];
		String[] PcKazandiklarý = new String[52];
		int[] PcKazandiklarýDegeri = new int[52];
		String[] OyuncuKazandiklari = new String[52];
		int[] OyuncuKazandiklariDegeri = new int[52];
		int[] OyuncuPistiSayi = new int[1];
		int[] PcPistiSayi = new int[1];
		int[] puanlar=new int[2];
		puanlar[0]=0;//0index pc
		puanlar[1]=0;//1 index oyuncu
		int[] KagýtKazanmaSay=new int[2];
		KagýtKazanmaSay[0]=0;//0index pc
		KagýtKazanmaSay[1]=0;//1 index oyuncu
		int YerKagýtSayisi;
		int AcilmisKagitSayisi=0;
		String OyunaBaslayan;
		String HamleSirasi;
	    
	    for (int i = 0; i < 52; i++) {	//diziye kart isim ve numaralarý atandý
	    	
			if(i<=12) {
				SiraliDeste[i]="MAÇA "+(i+1);
				SiraliDesteDegeri[i]=(i+1);
			}
			else if(i>=13 && i<=25) {
				SiraliDeste[i]="KUPA "+(i-12);
				SiraliDesteDegeri[i]=(i-12);
			}
			else if(i>=26 && i<=38) {
				SiraliDeste[i]="SÝNEK "+(i-25);
				SiraliDesteDegeri[i]=(i-25);
			}
			else if(i>=39 && i<=51) {
				SiraliDeste[i]="KARO "+(i-38);
				SiraliDesteDegeri[i]=(i-38);
			}	
			
		}
	    
	    
	    int[] dizikarno = new int[52];//karmak için gerekli sayýlarýn bulunacaðý dizi
	    
	    for (int h = 0; h <=51; h++) {
	    	
			int randdeger=Integer.valueOf( rastgelesayigetir());//rastgele sayýlar diziye atandý
			dizikarno[h]=randdeger;
				
	    }
			 
		TekrarVarmi(dizikarno);//random karýlan dizide tekrar eden sayý olmamasý test edildi
	     
		DesteKar(SiraliDeste,KarisikDeste,dizikarno,SiraliDesteDegeri,KarisikDesteDegeri);//random sayýlarýn olduðu diziye göre kart isimleri karýldý
		
		AcilmisKagitSayisi=YereKagitAc(KarisikDeste,YerdekiKagitlar,AcilmisKagitSayisi,YerdekiKagitlardegeri,KarisikDesteDegeri);//oyun baþýnda yere açýlacak 4 kaðýdý atadýk
		
		YerKagýtSayisi=4;
		
		OyunaBaslayan=KimBasliyor();//oyuna ilk kimin baþliyacaðý rasthele seçiliyor
		System.out.println(OyunaBaslayan+" kiþisi baslýyor");
	    
		HamleSirasi=OyunaBaslayan;

	   // int OyuncuPuan = 0, PCPuan = 0;
		
			System.out.println("//-----PÝÞTÝ OYUNU-----\\");
			
			
			for (int i = 0; i < 52; i++) {
			System.out.print(SiraliDeste[i]);
			System.out.println("  DEGERÝ: "+SiraliDesteDegeri[i]);
			}
			
			
			System.out.println("\nkarmak için dizi:\n");
			for (int say = 0; say <= 51; say++) {
				System.out.println(say+".deðer: "+dizikarno[say]);
				
			}
			
			System.out.println("\nkarýlmýþ halde deste:\n");
			for (int i = 0; i < 52; i++) {
				System.out.print(i+1+".kart: "+KarisikDeste[i]);
				System.out.println("  DEGERÝ: "+KarisikDesteDegeri[i]);
				}
			
			System.out.println("\nyere açýlan ilk 4 kaðýt:\n");
			for (int i = 0; i < 4; i++) {
				System.out.print(i+1+".kart: "+YerdekiKagitlar[i]);
				System.out.println("  DEGERÝ: "+YerdekiKagitlardegeri[i]);
				}
			
			
			System.out.println("\naçýlmýþ kaðýt sayýsý:"+AcilmisKagitSayisi);
			
			AcilmisKagitSayisi=ÝkiTarafaKagitDagit(PcEli,OyuncuEli,KarisikDeste,HamleSirasi,AcilmisKagitSayisi,PcEliDegeri,OyuncuEliDegeri,KarisikDesteDegeri);
			

			System.out.println("\npcnin eli :");
			for (int i = 0; i < 4; i++) {
				
				System.out.print(PcEli[i]);
				System.out.println("  degeri:  "+PcEliDegeri[i]);
			}
			
			System.out.println("oyuncunun eli :");
			for (int i = 0; i < 4; i++) {
				
				System.out.print(OyuncuEli[i]);
				System.out.println("  degeri:  "+OyuncuEliDegeri[i]);
			}
					
			System.out.println("\n\naçýlmýþ kaðýt sayýsý:"+AcilmisKagitSayisi);
			
			for(int elsay=0;elsay<5;elsay++) {
			
				for (int hamlesay = 0; hamlesay < 8; hamlesay++) {
				
					System.out.println("\n\n"+(hamlesay+1)+". HAMLE YAPILIYOR-----------------!!!!!!\n\n");
				
					YerKagýtSayisi=KartOyna(HamleSirasi,YerdekiKagitlar,YerdekiKagitlardegeri,YerKagýtSayisi,OyuncuEli,OyuncuEliDegeri,PcEli,PcEliDegeri,OyuncuKazandiklari,OyuncuKazandiklariDegeri,OyuncuPistiSayi,PcPistiSayi,PcKazandiklarý,PcKazandiklarýDegeri,puanlar,KagýtKazanmaSay);
				
					
					
					if(HamleSirasi=="oyuncu") {
						HamleSirasi="pc";
					}
					else {
						HamleSirasi="oyuncu";
					}
					
					
					System.out.println("kazandýðý kart pc: "+KagýtKazanmaSay[0]);
					System.out.println("kazandýðý kart oyuncu: "+KagýtKazanmaSay[1]);
				
					System.out.println("\nyerdeki kart sayýsý : "+YerKagýtSayisi);
				
					System.out.println("\nyere açýlan  kartlar:\n");
				
					for (int i = 0; i < YerKagýtSayisi; i++) {
					
						System.out.print(i+1+".kart: "+YerdekiKagitlar[i]);
						System.out.println("  DEGERÝ: "+YerdekiKagitlardegeri[i]);
					
						}
				}
				
				
				for (int i = 0; i < OyuncuKazandiklariDegeri.length; i++) {
					if(OyuncuKazandiklariDegeri[i]!=0) {
						
						if(OyuncuKazandiklari[i]=="SÝNEK 2") {
							
							puanlar[1]+=2;
						}
						if(OyuncuKazandiklari[i]=="KARO 10") {
							
							puanlar[1]+=3;
						}
						if(OyuncuKazandiklari[i]=="AS 1"||OyuncuKazandiklari[i]=="SÝNEK 1"||OyuncuKazandiklari[i]=="KARO 1"||OyuncuKazandiklari[i]=="MAÇA 1") {
							
							puanlar[1]+=3;
						}
						if(OyuncuKazandiklari[i]=="AS 11"||OyuncuKazandiklari[i]=="SÝNEK 11"||OyuncuKazandiklari[i]=="KARO 11"||OyuncuKazandiklari[i]=="MAÇA 11") {
	
							puanlar[1]+=3;
						}
						
						
						
						
					System.out.print("\noyuncu kazandýklarý:"+OyuncuKazandiklari[i]+" degeri:"+OyuncuKazandiklariDegeri[i]);
					}
					
					
				}
				System.out.println("\n");
					
					for (int k = 0; k < PcKazandiklarýDegeri.length; k++) {
						if(PcKazandiklarýDegeri[k]!=0) {
							
							if(PcKazandiklarý[k]=="SÝNEK 2") {
								
								puanlar[0]+=2;
							}
							if(PcKazandiklarý[k]=="KARO 10") {
								
								puanlar[0]+=3;
							}
							if(PcKazandiklarý[k]=="AS 1"||OyuncuKazandiklari[k]=="SÝNEK 1"||OyuncuKazandiklari[k]=="KARO 1"||OyuncuKazandiklari[k]=="MAÇA 1") {
								
								puanlar[0]+=3;
							}
							if(PcKazandiklarý[k]=="AS 11"||OyuncuKazandiklari[k]=="SÝNEK 11"||OyuncuKazandiklari[k]=="KARO 11"||OyuncuKazandiklari[k]=="MAÇA 11") {
		
								puanlar[0]+=3;
							}
							
						System.out.print("\nPC kazandýklarý:"+PcKazandiklarý[k]+" degeri:"+PcKazandiklarýDegeri[k]);
						}
					}
				
				for (int i = 0; i < 52; i++) {
					
					if(OyuncuKazandiklariDegeri[i]!=0) {
						
						
						if(OyuncuKazandiklari[i]=="SÝNEK 2") {
							
							puanlar[1]+=2;
						}
						if(OyuncuKazandiklari[i]=="KARO 10") {
							
							puanlar[1]+=3;
						}
						if(OyuncuKazandiklari[i]=="AS 1"||OyuncuKazandiklari[i]=="SÝNEK 1"||OyuncuKazandiklari[i]=="KARO 1"||OyuncuKazandiklari[i]=="MAÇA 1") {
							
							puanlar[1]+=3;
						}
						if(OyuncuKazandiklari[i]=="AS 11"||OyuncuKazandiklari[i]=="SÝNEK 11"||OyuncuKazandiklari[i]=="KARO 11"||OyuncuKazandiklari[i]=="MAÇA 11") {
	
							puanlar[1]+=3;
						}
						
					}
					
				}
				
				for (int i = 0; i < 52; i++) {
					
					if(PcKazandiklarýDegeri[i]!=0) {
						
						
						if(PcKazandiklarý[i]=="SÝNEK 2") {
							
							puanlar[0]+=2;
						}
						if(PcKazandiklarý[i]=="KARO 10") {
							
							puanlar[0]+=3;
						}
						if(PcKazandiklarý[i]=="AS 1"||OyuncuKazandiklari[i]=="SÝNEK 1"||OyuncuKazandiklari[i]=="KARO 1"||OyuncuKazandiklari[i]=="MAÇA 1") {
							
							puanlar[0]+=3;
						}
						if(PcKazandiklarý[i]=="AS 11"||OyuncuKazandiklari[i]=="SÝNEK 11"||OyuncuKazandiklari[i]=="KARO 11"||OyuncuKazandiklari[i]=="MAÇA 11") {
	
							puanlar[0]+=3;
						}
						
					}
					
				}
				
				AcilmisKagitSayisi=ÝkiTarafaKagitDagit(PcEli,OyuncuEli,KarisikDeste,HamleSirasi,AcilmisKagitSayisi,PcEliDegeri,OyuncuEliDegeri,KarisikDesteDegeri);
				
				System.out.println("-----------EL BÝTMÝÞTÝR ------\n");
				
				System.out.println("//---pc toplam puani : "+puanlar[0]);
				
				System.out.println("//---oyuncu toplam puani : "+puanlar[1]);
				
				System.out.println("\n\naçýlmýþ kaðýt sayýsý:"+AcilmisKagitSayisi);
				
				System.out.println("\nyerdeki kart sayýsý : "+YerKagýtSayisi);
				
				System.out.println("\nyere açýlan  kartlar:\n");
			
				for (int i = 0; i < YerKagýtSayisi; i++) {
				
					System.out.print(i+1+".kart: "+YerdekiKagitlar[i]);
					System.out.println("  DEGERÝ: "+YerdekiKagitlardegeri[i]);
				
					}
				
				System.out.println("\npcnin eli :");
				for (int i = 0; i < 4; i++) {
					
					System.out.print(PcEli[i]);
					System.out.println("  degeri:  "+PcEliDegeri[i]);
				}
				
				System.out.println("\noyuncunun eli :");
				for (int i = 0; i < 4; i++) {
					
					System.out.print(OyuncuEli[i]);
					System.out.println("  degeri:  "+OyuncuEliDegeri[i]);
				}
				
			
			}
			
			
			
			
			
			
			
			
			
	}
	
	
	public static int KartOyna(String hamlekimin,String[] yerdekikagitlar,int[] yerdekikagitlardegeri,int yerdekikagitsayisi,String[] oyuncueli,int[] oyuncuelidegeri,String[] pceli,int[] pcelidegeri,String[] userkazan,int[] userkazandeger,int[] oyuncupisti,int[] pcpisti,String[] pckazan,int[] pckazandeger,int[] puanlari,int[] kagitkazanmasay) {
		
		
		if (hamlekimin=="oyuncu") {
			
			int secilenkartno=OyuncuKartSectir();
			System.out.println("\noyuncunun attýðý kart :"+oyuncueli[secilenkartno-1]);
			
			if(yerdekikagitsayisi>0 && yerdekikagitlardegeri[yerdekikagitsayisi-1]==oyuncuelidegeri[secilenkartno-1]) {
				
				for (int kartkazansay = 0; kartkazansay < yerdekikagitsayisi; kartkazansay++) {
					
					userkazan[kartkazansay+(kagitkazanmasay[1])]=yerdekikagitlar[kartkazansay];
					userkazandeger[kartkazansay+(kagitkazanmasay[1])]=yerdekikagitlardegeri[kartkazansay];
					kagitkazanmasay[1]++;
					yerdekikagitlar[kartkazansay]="";
					yerdekikagitlardegeri[kartkazansay]=0;
					
				}
				
				userkazan[yerdekikagitsayisi+(kagitkazanmasay[1])]=oyuncueli[secilenkartno-1];
				userkazandeger[yerdekikagitsayisi+(kagitkazanmasay[1])]=oyuncuelidegeri[secilenkartno-1];
				kagitkazanmasay[1]++;
				oyuncueli[secilenkartno-1]="BOÞ";
				oyuncuelidegeri[secilenkartno-1]=999;
				
				yerdekikagitsayisi=0;
				
			}
			else if(oyuncuelidegeri[secilenkartno-1]==11){
				
				for (int kartkazansay = 0; kartkazansay < yerdekikagitsayisi; kartkazansay++) {
					
					userkazan[kartkazansay+(kagitkazanmasay[1])]=yerdekikagitlar[kartkazansay];
					userkazandeger[kartkazansay+(kagitkazanmasay[1])]=yerdekikagitlardegeri[kartkazansay];
					kagitkazanmasay[1]++;
					yerdekikagitlar[kartkazansay]="";
					yerdekikagitlardegeri[kartkazansay]=0;
					
				}
				
				userkazan[yerdekikagitsayisi+kagitkazanmasay[1]]=oyuncueli[secilenkartno-1];
				userkazandeger[yerdekikagitsayisi+kagitkazanmasay[1]]=oyuncuelidegeri[secilenkartno-1];
				kagitkazanmasay[1]++;
				oyuncueli[secilenkartno-1]="BOÞ";
				oyuncuelidegeri[secilenkartno-1]=999;

				yerdekikagitsayisi=0;

			}
			else if(yerdekikagitsayisi==1 && yerdekikagitlardegeri[yerdekikagitsayisi-1]==pcelidegeri[secilenkartno-1]  ){
				
				for(int i=0;i<2;i++) {
					
					userkazan[i+(kagitkazanmasay[1])]=oyuncueli[secilenkartno-1];
					userkazandeger[i+(kagitkazanmasay[1])]=oyuncuelidegeri[secilenkartno-1];
					kagitkazanmasay[1]++;
					yerdekikagitlar[i]="";
					yerdekikagitlardegeri[i]=0;
					oyuncueli[secilenkartno-1]="BOÞ";
					oyuncuelidegeri[secilenkartno-1]=999;
				}
				oyuncupisti[0]++;
				yerdekikagitsayisi=0;
				
			}
			else if(yerdekikagitsayisi==0){
				yerdekikagitlar[yerdekikagitsayisi]=oyuncueli[secilenkartno-1];
				yerdekikagitlardegeri[yerdekikagitsayisi]=oyuncuelidegeri[secilenkartno-1];
				yerdekikagitsayisi=1;
				oyuncueli[secilenkartno-1]="BOÞ";
				oyuncuelidegeri[secilenkartno-1]=999;
			}
			else {
				yerdekikagitlar[yerdekikagitsayisi]=oyuncueli[secilenkartno-1];
				yerdekikagitlardegeri[yerdekikagitsayisi]=oyuncuelidegeri[secilenkartno-1];
				yerdekikagitsayisi++;
				oyuncueli[secilenkartno-1]="BOÞ";
				oyuncuelidegeri[secilenkartno-1]=999;
				
			}
		}
		
		if (hamlekimin=="pc") {
			
			int pcsecilenkart=PcKartSectir(pceli,pcelidegeri);
			System.out.println("bota seçilen kart :"+pcsecilenkart);
			
			if(yerdekikagitsayisi>0 && yerdekikagitlardegeri[yerdekikagitsayisi-1]==pcelidegeri[pcsecilenkart]  ) {
				
				for (int kartkazansay = 0; kartkazansay < yerdekikagitsayisi; kartkazansay++) {
					
					pckazan[kartkazansay+(kagitkazanmasay[0])]=yerdekikagitlar[kartkazansay];
					pckazandeger[kartkazansay+(kagitkazanmasay[0])]=yerdekikagitlardegeri[kartkazansay];
					kagitkazanmasay[0]++;
					yerdekikagitlar[kartkazansay]="";
					yerdekikagitlardegeri[kartkazansay]=0;
					
				}
				
				pckazan[yerdekikagitsayisi+(kagitkazanmasay[0])]=pceli[pcsecilenkart];
				pckazandeger[yerdekikagitsayisi+(kagitkazanmasay[0])]=pcelidegeri[pcsecilenkart];
				kagitkazanmasay[0]++;
				pceli[pcsecilenkart]="BOÞ";
				System.out.println("uyarý 1");
				pcelidegeri[pcsecilenkart]=999;
				yerdekikagitsayisi=0;
				
			}
			else if(pcelidegeri[pcsecilenkart]==11){
				
				for (int kartkazansay = 0; kartkazansay < yerdekikagitsayisi; kartkazansay++) {
					
					pckazan[kartkazansay+(kagitkazanmasay[0])]=yerdekikagitlar[kartkazansay];
					pckazandeger[kartkazansay+(kagitkazanmasay[0])]=yerdekikagitlardegeri[kartkazansay];
					kagitkazanmasay[0]++;
					yerdekikagitlar[kartkazansay]="";
					yerdekikagitlardegeri[kartkazansay]=0;
					
				}
				
				pckazan[yerdekikagitsayisi+kagitkazanmasay[0]]=pceli[pcsecilenkart];
				pckazandeger[yerdekikagitsayisi+kagitkazanmasay[0]]=pcelidegeri[pcsecilenkart];
				kagitkazanmasay[0]++;
				pceli[pcsecilenkart]="BOÞ";
				System.out.println("uyarý 2");
				pcelidegeri[pcsecilenkart]=999;

				yerdekikagitsayisi=0;

			}
			else if(yerdekikagitsayisi==1 && yerdekikagitlardegeri[yerdekikagitsayisi-1]==oyuncuelidegeri[pcsecilenkart] ){
				
				for(int i=0;i<2;i++) {
					
					pckazan[i+(kagitkazanmasay[0])]=oyuncueli[pcsecilenkart];
					pckazandeger[i+(kagitkazanmasay[0])]=pcelidegeri[pcsecilenkart];
					kagitkazanmasay[0]++;
					yerdekikagitlar[i]="";
					yerdekikagitlardegeri[i]=0;
					pceli[pcsecilenkart]="BOÞ";
					System.out.println("uyarý 3");
					pcelidegeri[pcsecilenkart]=999;
				}
				pcpisti[0]++;
				yerdekikagitsayisi=0;
				
			}
			else if(yerdekikagitsayisi==0) {
				yerdekikagitlar[yerdekikagitsayisi]=pceli[pcsecilenkart];
				yerdekikagitlardegeri[yerdekikagitsayisi]=pcelidegeri[pcsecilenkart];
				yerdekikagitsayisi=1;
				pceli[pcsecilenkart]="BOÞ";
				System.out.println("uyarý 4");
				pcelidegeri[pcsecilenkart]=999;
			}
			else {
				
				yerdekikagitlar[yerdekikagitsayisi]=pceli[pcsecilenkart];
				yerdekikagitlardegeri[yerdekikagitsayisi]=pcelidegeri[pcsecilenkart];
				yerdekikagitsayisi++;
				pceli[pcsecilenkart]="BOÞ";
				System.out.println("uyarý 5");
				pcelidegeri[pcsecilenkart]=999;
				
			}
		}
		
		for (int i = 0; i < pckazandeger.length; i++) {
			if(pckazandeger[i]!=0) {
			System.out.print("pc kazandýklarý: "+pckazan[i]+" degeri: "+pckazandeger[i]);
			}
		}
		System.out.println("\n");
		
		for (int i = 0; i < userkazandeger.length; i++) {
			if(userkazandeger[i]!=0) {
			System.out.print("\noyuncu kazandýklarý: "+userkazan[i]+" degeri: "+userkazandeger[i]);
			}
		}
		
		for (int i = 0; i < 4; i++) {
			System.out.println("oyuncu eli "+i+".deger : "+oyuncueli[i]+" degeri : "+oyuncuelidegeri[i]);
		}
		System.out.println("\n");
		for (int i = 0; i < 4; i++) {
			System.out.println("bot eli "+i+".deger : "+pceli[i]+" degeri : "+pcelidegeri[i]);
		}
		
		
		return yerdekikagitsayisi;
		
		
		
	}
	
	
	public static int PcKartSectir (String[] pcelial,int[] pcelidegeral) {
		
		
		Random RandSayi = new Random();
		 
		 int kartsectir=RandSayi.nextInt(4);
		 
		 if(pcelidegeral[kartsectir]==999) {
			 
			 kartsectir=PcKartSectir(pcelial,pcelidegeral);
		 }
		 else if(pcelidegeral[kartsectir]!=999){
			 System.out.println("\nbota kart seçtirdik: "+(kartsectir+1)+"\n");
			 System.out.println("BOTUN ATTIÐI KART : "+pcelial[kartsectir]);
		 }
		return kartsectir;	 
		
	}
	
	public static int OyuncuKartSectir() {
		int AtilacakKartSec=0;
		Scanner girdi = new Scanner(System.in);
		System.out.println("ATILACAK KARTIN YERÝNÝ GÝRÝN");
		AtilacakKartSec = girdi.nextInt();
			
		System.out.println("atilcak kart seçimi "+AtilacakKartSec);
		
		
		return AtilacakKartSec;
	}
	
	public static int ÝkiTarafaKagitDagit(String[] pcel,String[]userel,String[] karisikdiziyial,String basliyan,int acilmiskagit,int[]pceldeger,int[]oyuncueldeger,int[]karisikdizideger){
		
		if(basliyan=="oyuncu") {
			for (int dagitsay = 0; dagitsay < 4; dagitsay++) {
				userel[dagitsay]=karisikdiziyial[acilmiskagit+dagitsay];
				oyuncueldeger[dagitsay]=karisikdizideger[acilmiskagit+dagitsay];
				pcel[dagitsay]=karisikdiziyial[(acilmiskagit+4)+dagitsay];
				pceldeger[dagitsay]=karisikdizideger[(acilmiskagit+4)+dagitsay];
			}		 
		}
		else if(basliyan=="pc") {
			for (int dagitsay = 0; dagitsay < 4; dagitsay++) {
				pcel[dagitsay]=karisikdiziyial[acilmiskagit+dagitsay];
				pceldeger[dagitsay]=karisikdizideger[acilmiskagit+dagitsay];
				userel[dagitsay]=karisikdiziyial[(acilmiskagit+4)+dagitsay];
				oyuncueldeger[dagitsay]=karisikdizideger[(acilmiskagit+4)+dagitsay];
			}
		}
		acilmiskagit+=8;
		return acilmiskagit;
		
	}
	
	public static String KimBasliyor() {
		int basla;
		String kisi;
		basla=rastgelesayigetir()%2;
		
		if(basla==0) {
			kisi="oyuncu";
		}
		else {
			kisi="pc";
		}
		return kisi;
	}
	
	public static int YereKagitAc(String[] karisikdizial,String[] yerdizi,int acilmiskagitsayisi,int[]yerdizideger,int[]karisikdizideger) {
		for (int yeresay = 0; yeresay < 4; yeresay++) {
			
			yerdizi[yeresay]=karisikdizial[yeresay];
			yerdizideger[yeresay]=karisikdizideger[yeresay];
			acilmiskagitsayisi++;
			
		}
		return acilmiskagitsayisi;
	}
	
	
	public static void DesteKar(String[] siralidizi ,String[] karilidizi,int []dizikar,int []siralidizideger,int []karilidizideger){
		
		for (int karmasayi = 0; karmasayi < karilidizi.length; karmasayi++) {
						
			karilidizi[karmasayi]=siralidizi[dizikar[karmasayi]];
			karilidizideger[karmasayi]=siralidizideger[dizikar[karmasayi]];
					
		}
		
	}
	
	public static void TekrarVarmi(int[] dizi) {
		String tekrardurum="yok";
		for (int kontrol1 = 0; kontrol1 < 51; kontrol1++) {
			for (int kontrol2 = 0; kontrol2 < kontrol1; kontrol2++) {
				
				if(dizi[kontrol1]==dizi[kontrol2]) {
					tekrardurum="var";
					dizi[kontrol1]=rastgelesayigetir(); 				
				}
				
			}
		}
		
		if(tekrardurum=="var") {
			TekrarVarmi(dizi);
			}
		
	}
	
	
	
	public static int rastgelesayigetir() {
		
		Random RandSayi = new Random();
		 
		 int DesteRandSayi=RandSayi.nextInt(52);
		 
		 return (DesteRandSayi);
	}


	
	
	
	
	
	
	
	
	
}
