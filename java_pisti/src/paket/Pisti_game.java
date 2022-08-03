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
		String[] PcKazandiklar� = new String[52];
		int[] PcKazandiklar�Degeri = new int[52];
		String[] OyuncuKazandiklari = new String[52];
		int[] OyuncuKazandiklariDegeri = new int[52];
		int[] OyuncuPistiSayi = new int[1];
		int[] PcPistiSayi = new int[1];
		int[] puanlar=new int[2];
		puanlar[0]=0;//0index pc
		puanlar[1]=0;//1 index oyuncu
		int[] Kag�tKazanmaSay=new int[2];
		Kag�tKazanmaSay[0]=0;//0index pc
		Kag�tKazanmaSay[1]=0;//1 index oyuncu
		int YerKag�tSayisi;
		int AcilmisKagitSayisi=0;
		String OyunaBaslayan;
		String HamleSirasi;
	    
	    for (int i = 0; i < 52; i++) {	//diziye kart isim ve numaralar� atand�
	    	
			if(i<=12) {
				SiraliDeste[i]="MA�A "+(i+1);
				SiraliDesteDegeri[i]=(i+1);
			}
			else if(i>=13 && i<=25) {
				SiraliDeste[i]="KUPA "+(i-12);
				SiraliDesteDegeri[i]=(i-12);
			}
			else if(i>=26 && i<=38) {
				SiraliDeste[i]="S�NEK "+(i-25);
				SiraliDesteDegeri[i]=(i-25);
			}
			else if(i>=39 && i<=51) {
				SiraliDeste[i]="KARO "+(i-38);
				SiraliDesteDegeri[i]=(i-38);
			}	
			
		}
	    
	    
	    int[] dizikarno = new int[52];//karmak i�in gerekli say�lar�n bulunaca�� dizi
	    
	    for (int h = 0; h <=51; h++) {
	    	
			int randdeger=Integer.valueOf( rastgelesayigetir());//rastgele say�lar diziye atand�
			dizikarno[h]=randdeger;
				
	    }
			 
		TekrarVarmi(dizikarno);//random kar�lan dizide tekrar eden say� olmamas� test edildi
	     
		DesteKar(SiraliDeste,KarisikDeste,dizikarno,SiraliDesteDegeri,KarisikDesteDegeri);//random say�lar�n oldu�u diziye g�re kart isimleri kar�ld�
		
		AcilmisKagitSayisi=YereKagitAc(KarisikDeste,YerdekiKagitlar,AcilmisKagitSayisi,YerdekiKagitlardegeri,KarisikDesteDegeri);//oyun ba��nda yere a��lacak 4 ka��d� atad�k
		
		YerKag�tSayisi=4;
		
		OyunaBaslayan=KimBasliyor();//oyuna ilk kimin ba�liyaca�� rasthele se�iliyor
		System.out.println(OyunaBaslayan+" ki�isi basl�yor");
	    
		HamleSirasi=OyunaBaslayan;

	   // int OyuncuPuan = 0, PCPuan = 0;
		
			System.out.println("//-----P��T� OYUNU-----\\");
			
			
			for (int i = 0; i < 52; i++) {
			System.out.print(SiraliDeste[i]);
			System.out.println("  DEGER�: "+SiraliDesteDegeri[i]);
			}
			
			
			System.out.println("\nkarmak i�in dizi:\n");
			for (int say = 0; say <= 51; say++) {
				System.out.println(say+".de�er: "+dizikarno[say]);
				
			}
			
			System.out.println("\nkar�lm�� halde deste:\n");
			for (int i = 0; i < 52; i++) {
				System.out.print(i+1+".kart: "+KarisikDeste[i]);
				System.out.println("  DEGER�: "+KarisikDesteDegeri[i]);
				}
			
			System.out.println("\nyere a��lan ilk 4 ka��t:\n");
			for (int i = 0; i < 4; i++) {
				System.out.print(i+1+".kart: "+YerdekiKagitlar[i]);
				System.out.println("  DEGER�: "+YerdekiKagitlardegeri[i]);
				}
			
			
			System.out.println("\na��lm�� ka��t say�s�:"+AcilmisKagitSayisi);
			
			AcilmisKagitSayisi=�kiTarafaKagitDagit(PcEli,OyuncuEli,KarisikDeste,HamleSirasi,AcilmisKagitSayisi,PcEliDegeri,OyuncuEliDegeri,KarisikDesteDegeri);
			

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
					
			System.out.println("\n\na��lm�� ka��t say�s�:"+AcilmisKagitSayisi);
			
			for(int elsay=0;elsay<5;elsay++) {
			
				for (int hamlesay = 0; hamlesay < 8; hamlesay++) {
				
					System.out.println("\n\n"+(hamlesay+1)+". HAMLE YAPILIYOR-----------------!!!!!!\n\n");
				
					YerKag�tSayisi=KartOyna(HamleSirasi,YerdekiKagitlar,YerdekiKagitlardegeri,YerKag�tSayisi,OyuncuEli,OyuncuEliDegeri,PcEli,PcEliDegeri,OyuncuKazandiklari,OyuncuKazandiklariDegeri,OyuncuPistiSayi,PcPistiSayi,PcKazandiklar�,PcKazandiklar�Degeri,puanlar,Kag�tKazanmaSay);
				
					
					
					if(HamleSirasi=="oyuncu") {
						HamleSirasi="pc";
					}
					else {
						HamleSirasi="oyuncu";
					}
					
					
					System.out.println("kazand��� kart pc: "+Kag�tKazanmaSay[0]);
					System.out.println("kazand��� kart oyuncu: "+Kag�tKazanmaSay[1]);
				
					System.out.println("\nyerdeki kart say�s� : "+YerKag�tSayisi);
				
					System.out.println("\nyere a��lan  kartlar:\n");
				
					for (int i = 0; i < YerKag�tSayisi; i++) {
					
						System.out.print(i+1+".kart: "+YerdekiKagitlar[i]);
						System.out.println("  DEGER�: "+YerdekiKagitlardegeri[i]);
					
						}
				}
				
				
				for (int i = 0; i < OyuncuKazandiklariDegeri.length; i++) {
					if(OyuncuKazandiklariDegeri[i]!=0) {
						
						if(OyuncuKazandiklari[i]=="S�NEK 2") {
							
							puanlar[1]+=2;
						}
						if(OyuncuKazandiklari[i]=="KARO 10") {
							
							puanlar[1]+=3;
						}
						if(OyuncuKazandiklari[i]=="AS 1"||OyuncuKazandiklari[i]=="S�NEK 1"||OyuncuKazandiklari[i]=="KARO 1"||OyuncuKazandiklari[i]=="MA�A 1") {
							
							puanlar[1]+=3;
						}
						if(OyuncuKazandiklari[i]=="AS 11"||OyuncuKazandiklari[i]=="S�NEK 11"||OyuncuKazandiklari[i]=="KARO 11"||OyuncuKazandiklari[i]=="MA�A 11") {
	
							puanlar[1]+=3;
						}
						
						
						
						
					System.out.print("\noyuncu kazand�klar�:"+OyuncuKazandiklari[i]+" degeri:"+OyuncuKazandiklariDegeri[i]);
					}
					
					
				}
				System.out.println("\n");
					
					for (int k = 0; k < PcKazandiklar�Degeri.length; k++) {
						if(PcKazandiklar�Degeri[k]!=0) {
							
							if(PcKazandiklar�[k]=="S�NEK 2") {
								
								puanlar[0]+=2;
							}
							if(PcKazandiklar�[k]=="KARO 10") {
								
								puanlar[0]+=3;
							}
							if(PcKazandiklar�[k]=="AS 1"||OyuncuKazandiklari[k]=="S�NEK 1"||OyuncuKazandiklari[k]=="KARO 1"||OyuncuKazandiklari[k]=="MA�A 1") {
								
								puanlar[0]+=3;
							}
							if(PcKazandiklar�[k]=="AS 11"||OyuncuKazandiklari[k]=="S�NEK 11"||OyuncuKazandiklari[k]=="KARO 11"||OyuncuKazandiklari[k]=="MA�A 11") {
		
								puanlar[0]+=3;
							}
							
						System.out.print("\nPC kazand�klar�:"+PcKazandiklar�[k]+" degeri:"+PcKazandiklar�Degeri[k]);
						}
					}
				
				for (int i = 0; i < 52; i++) {
					
					if(OyuncuKazandiklariDegeri[i]!=0) {
						
						
						if(OyuncuKazandiklari[i]=="S�NEK 2") {
							
							puanlar[1]+=2;
						}
						if(OyuncuKazandiklari[i]=="KARO 10") {
							
							puanlar[1]+=3;
						}
						if(OyuncuKazandiklari[i]=="AS 1"||OyuncuKazandiklari[i]=="S�NEK 1"||OyuncuKazandiklari[i]=="KARO 1"||OyuncuKazandiklari[i]=="MA�A 1") {
							
							puanlar[1]+=3;
						}
						if(OyuncuKazandiklari[i]=="AS 11"||OyuncuKazandiklari[i]=="S�NEK 11"||OyuncuKazandiklari[i]=="KARO 11"||OyuncuKazandiklari[i]=="MA�A 11") {
	
							puanlar[1]+=3;
						}
						
					}
					
				}
				
				for (int i = 0; i < 52; i++) {
					
					if(PcKazandiklar�Degeri[i]!=0) {
						
						
						if(PcKazandiklar�[i]=="S�NEK 2") {
							
							puanlar[0]+=2;
						}
						if(PcKazandiklar�[i]=="KARO 10") {
							
							puanlar[0]+=3;
						}
						if(PcKazandiklar�[i]=="AS 1"||OyuncuKazandiklari[i]=="S�NEK 1"||OyuncuKazandiklari[i]=="KARO 1"||OyuncuKazandiklari[i]=="MA�A 1") {
							
							puanlar[0]+=3;
						}
						if(PcKazandiklar�[i]=="AS 11"||OyuncuKazandiklari[i]=="S�NEK 11"||OyuncuKazandiklari[i]=="KARO 11"||OyuncuKazandiklari[i]=="MA�A 11") {
	
							puanlar[0]+=3;
						}
						
					}
					
				}
				
				AcilmisKagitSayisi=�kiTarafaKagitDagit(PcEli,OyuncuEli,KarisikDeste,HamleSirasi,AcilmisKagitSayisi,PcEliDegeri,OyuncuEliDegeri,KarisikDesteDegeri);
				
				System.out.println("-----------EL B�TM��T�R ------\n");
				
				System.out.println("//---pc toplam puani : "+puanlar[0]);
				
				System.out.println("//---oyuncu toplam puani : "+puanlar[1]);
				
				System.out.println("\n\na��lm�� ka��t say�s�:"+AcilmisKagitSayisi);
				
				System.out.println("\nyerdeki kart say�s� : "+YerKag�tSayisi);
				
				System.out.println("\nyere a��lan  kartlar:\n");
			
				for (int i = 0; i < YerKag�tSayisi; i++) {
				
					System.out.print(i+1+".kart: "+YerdekiKagitlar[i]);
					System.out.println("  DEGER�: "+YerdekiKagitlardegeri[i]);
				
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
			System.out.println("\noyuncunun att��� kart :"+oyuncueli[secilenkartno-1]);
			
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
				oyuncueli[secilenkartno-1]="BO�";
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
				oyuncueli[secilenkartno-1]="BO�";
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
					oyuncueli[secilenkartno-1]="BO�";
					oyuncuelidegeri[secilenkartno-1]=999;
				}
				oyuncupisti[0]++;
				yerdekikagitsayisi=0;
				
			}
			else if(yerdekikagitsayisi==0){
				yerdekikagitlar[yerdekikagitsayisi]=oyuncueli[secilenkartno-1];
				yerdekikagitlardegeri[yerdekikagitsayisi]=oyuncuelidegeri[secilenkartno-1];
				yerdekikagitsayisi=1;
				oyuncueli[secilenkartno-1]="BO�";
				oyuncuelidegeri[secilenkartno-1]=999;
			}
			else {
				yerdekikagitlar[yerdekikagitsayisi]=oyuncueli[secilenkartno-1];
				yerdekikagitlardegeri[yerdekikagitsayisi]=oyuncuelidegeri[secilenkartno-1];
				yerdekikagitsayisi++;
				oyuncueli[secilenkartno-1]="BO�";
				oyuncuelidegeri[secilenkartno-1]=999;
				
			}
		}
		
		if (hamlekimin=="pc") {
			
			int pcsecilenkart=PcKartSectir(pceli,pcelidegeri);
			System.out.println("bota se�ilen kart :"+pcsecilenkart);
			
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
				pceli[pcsecilenkart]="BO�";
				System.out.println("uyar� 1");
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
				pceli[pcsecilenkart]="BO�";
				System.out.println("uyar� 2");
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
					pceli[pcsecilenkart]="BO�";
					System.out.println("uyar� 3");
					pcelidegeri[pcsecilenkart]=999;
				}
				pcpisti[0]++;
				yerdekikagitsayisi=0;
				
			}
			else if(yerdekikagitsayisi==0) {
				yerdekikagitlar[yerdekikagitsayisi]=pceli[pcsecilenkart];
				yerdekikagitlardegeri[yerdekikagitsayisi]=pcelidegeri[pcsecilenkart];
				yerdekikagitsayisi=1;
				pceli[pcsecilenkart]="BO�";
				System.out.println("uyar� 4");
				pcelidegeri[pcsecilenkart]=999;
			}
			else {
				
				yerdekikagitlar[yerdekikagitsayisi]=pceli[pcsecilenkart];
				yerdekikagitlardegeri[yerdekikagitsayisi]=pcelidegeri[pcsecilenkart];
				yerdekikagitsayisi++;
				pceli[pcsecilenkart]="BO�";
				System.out.println("uyar� 5");
				pcelidegeri[pcsecilenkart]=999;
				
			}
		}
		
		for (int i = 0; i < pckazandeger.length; i++) {
			if(pckazandeger[i]!=0) {
			System.out.print("pc kazand�klar�: "+pckazan[i]+" degeri: "+pckazandeger[i]);
			}
		}
		System.out.println("\n");
		
		for (int i = 0; i < userkazandeger.length; i++) {
			if(userkazandeger[i]!=0) {
			System.out.print("\noyuncu kazand�klar�: "+userkazan[i]+" degeri: "+userkazandeger[i]);
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
			 System.out.println("\nbota kart se�tirdik: "+(kartsectir+1)+"\n");
			 System.out.println("BOTUN ATTI�I KART : "+pcelial[kartsectir]);
		 }
		return kartsectir;	 
		
	}
	
	public static int OyuncuKartSectir() {
		int AtilacakKartSec=0;
		Scanner girdi = new Scanner(System.in);
		System.out.println("ATILACAK KARTIN YER�N� G�R�N");
		AtilacakKartSec = girdi.nextInt();
			
		System.out.println("atilcak kart se�imi "+AtilacakKartSec);
		
		
		return AtilacakKartSec;
	}
	
	public static int �kiTarafaKagitDagit(String[] pcel,String[]userel,String[] karisikdiziyial,String basliyan,int acilmiskagit,int[]pceldeger,int[]oyuncueldeger,int[]karisikdizideger){
		
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
