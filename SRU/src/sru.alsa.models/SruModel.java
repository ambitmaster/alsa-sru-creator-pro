package sru.alsa.models;

import java.awt.FileDialog;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JFrame;

public class SruModel {

		private JFrame sruFrame;
		
		public SruModel(){

		}

		public void SruFileTasks(JFrame sruFrame){
			this.sruFrame = sruFrame;
		}

		public void taskReadFile(){
			FileDialog fileDialog = new FileDialog(sruFrame,"Choose a file",FileDialog.LOAD);
			fileDialog.setDirectory("C:\\");
			fileDialog.setFile("*.sru");
			fileDialog.setVisible(true);
			try{
				String fileSKU = fileDialog.getFile();
				FileReader fileReader = new FileReader(fileSKU);
				Scanner scannerSKU = new Scanner(fileReader);
				String lines;
				while(scannerSKU.hasNextLine()){
					lines = scannerSKU.nextLine();
					StringTokenizer token = new StringTokenizer(lines);
					try{
						if(token.countTokens() != 1){
							String data_post = token.nextToken(" ");
							String data_value = token.nextToken("#");
							System.out.println(data_post + " | " + data_value);
						}else{
							System.err.println("Skipping bad line " + lines);
						}

					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				}
				scannerSKU.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

		public void taskCreateINFOSRU(){
			String PRODUKT = "SRU";
			String MEDIAID = "DISK_12";
			String SKAPAD = "20130428 174557";
			String PROGRAM = "ALSA SRU PRO 1.0";
			String FILNAMN = "blanketter.sru";
			String ORGNR = "197601187134";
			String NAMN = "Databokforaren";
			String ADRESS = "box 159";
			String POSTNR = "12345";
			String POSTORT = "Skattstad";
			String AVDELNING = "Ekonomi";
			String KONTAKT = "Karl Karlsson";
			String EMAIL = "kk@Databokforaren";
			String TELEFON = "08-2121212";
			String FAX = "08-1212121";

			List<String> sruLines = Arrays.asList(
					"#DATABESKRIVNING_START",
					"#PRODUKT "+PRODUKT,
					"#MEDIAID "+MEDIAID,
					"#SKAPAD "+SKAPAD,
					"#PROGRAM "+PROGRAM,
					"#FILNAMN "+FILNAMN,
					"#DATABESKRIVNING_SLUT",
					"#MEDIELEV_START",
					"#ORGNR "+ORGNR,
					"#NAMN "+NAMN,
					"#ADRESS "+ADRESS,
					"#POSTNR "+POSTNR,
					"#POSTORT "+POSTORT,
					"#AVDELNING "+AVDELNING,
					"#KONTAKT "+KONTAKT,
					"#EMAIL "+EMAIL,
					"#TELEFON "+TELEFON,
					"#FAX "+FAX,
					"#MEDIELEV_SLUT"
					);
			Path sruFile = Paths.get("info.sru");
			try {
				Files.write(sruFile,sruLines, Charset.forName("UTF-8"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}

		public void taskCreateBLNKSRU(){
			String BLANKETT = "N7-2013P1";
			String IDENTITET = "197601187134 20130426 174557";
			String NAMN = "Kalle Andersson";
			String SYSTEMINFO = "klarmarkerad 20130426 u. a.";
			String UPPGIFT7011 = "20120201";
			String UPPGIFT7012 = "20130131";
			String UPPGIFT8580 = "7601187134";
			String UPPGIFT8585 = "20120315";
			String UPPGIFT8346 = "1000";
			String UPPGIFT8345 = "1250";
			String UPPGIFT8344 = "50500";
			String UPPGIFT8343 = "89500";
			String UPPGIFT8342 = "12500";
			String UPPGIFT8341 = "8500";
			String UPPGIFT8340 = "2555";
			List<String> sruLines = Arrays.asList(
					"#BLANKETT "+BLANKETT,
					"#IDENTITET "+IDENTITET,
					"#NAMN "+NAMN,
					"#SYSTEMINFO "+SYSTEMINFO,
					"#UPPGIFT 7011 "+UPPGIFT7011,
					"#UPPGIFT 7012 "+UPPGIFT7012,
					"#UPPGIFT 8580 "+UPPGIFT8580,
					"#UPPGIFT 8585 "+UPPGIFT8585,
					"#UPPGIFT 8346 "+UPPGIFT8346,
					"#UPPGIFT 8345 "+UPPGIFT8345,
					"#UPPGIFT 8344 "+UPPGIFT8344,
					"#UPPGIFT 8343 "+UPPGIFT8343,
					"#UPPGIFT 8342 "+UPPGIFT8342,
					"#UPPGIFT 8341 "+UPPGIFT8341,
					"#UPPGIFT 8340 "+UPPGIFT8340,
					"#BLANKETTSLUT",
					"#FIL_SLUT");
			Path sruFile = Paths.get("blanketter.sru");
			try {
				Files.write(sruFile,sruLines, Charset.forName("UTF-8"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		
	}
