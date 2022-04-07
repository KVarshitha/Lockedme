package project1;
import java.util.*;
import java.io.*;
public class project {
	public static void main(String[] args) {
		int choice=0;
	
		File files = new File("C:\\Users\\Hari\\Desktop\\Phase 3\\project1");
		File[] listoffiles = files.listFiles();
		List<File> arrayoffiles = Arrays.asList(listoffiles);
		do
			{
			System.out.println("Welcome to Company Lockers Ltd");
			System.out.println("Developed by Varshitha");
			System.out.println("Select an option from the menu\n1. Display all files\n2. Operations\n3. Exit");
			Scanner sc = new Scanner(System.in);
			try {
				
				choice = sc.nextInt();
				if(choice>3) {
					System.out.println("Invalid Input");
				}
			}catch(InputMismatchException e)
			{
				System.out.println("Invalid Input");
			}
			
			switch (choice) {
				case 1: {
					int count=1;
					Collections.sort(arrayoffiles);
					for (int i = 0; i < listoffiles.length; i++) 
						{
					  		if (listoffiles[i].isFile()) 
					  		{
					  			System.out.println(count+". "+listoffiles[i].getName());
					  			count++;
					  		} 
						}
						break;
					}
				case 2: {
					int choice2=0;
					do {
						
					System.out.println("Select an option from the menu\n1. Add a new file\n2. Delete a file\n3. Search for a file\n4. Retun to Main Menu");
					sc = new Scanner(System.in);
					try {
						
						choice2 = sc.nextInt();
						if(choice>4) {
							System.out.println("Invalid Input");
						}
					}catch(InputMismatchException e)
					{
						System.out.println("Invalid Input");
					}
					
					if(choice2==1) {
						FileOutputStream ifile =  null;
						try {
						
							System.out.println("Enter the name of the file");
							String filename = sc.next();
							ifile=new FileOutputStream(filename,true);
							System.out.println("File Succesfully created");
							
						}catch(IOException e){
							System.out.println("Error occured");
						}finally {
						}
							if(ifile != null) {
								try {
									ifile.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
						else if(choice2==2)
						{	
							boolean delete=false;
							System.out.println("Enter the name of the file to be deleted");
							String DFileName= sc.next();
							for(File i:listoffiles) {
								if(i.getName().equals(DFileName))
								{
									delete=i.delete();
									System.out.println("Deleted file "+i.getName());
								}
								}
							if(!delete)
							{
								System.out.println("File Not Found");
							}
							
						}else if(choice2==3)
						{
							System.out.println("Enter the name of the file");
							int flag=0;
							String fname= sc.next();
							String[] filenamestring = files.list();
							for(int i=0; i<filenamestring.length;i++) {
								if(fname.equals(filenamestring[i])) {
									System.out.println(fname + "found");
								flag=1;
								}
							}
							if(flag==0)
							{
								System.out.println("File Not found");
							}
						}else if(choice2==4)
						{
							break;
						}
					}while(choice2!=4);
					break;
				}
				case 3:
				{
					break;
				}
				
			}
			}while(choice!=3);
	
		}
	}


