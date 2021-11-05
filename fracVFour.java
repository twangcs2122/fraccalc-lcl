import java.util.Scanner;
public class fracVFour {
	static Scanner userInput=new Scanner(System.in);
	public static void main(String[] args) {
		String fractions = userInput.nextLine();
		String[] splitParts= fractions.split(" "); 
		int[] splitOne= parseNums(splitParts[0]);
		int[] splitTwo= parseNums(splitParts[2]);
		int[] result= new int[3];
		if (splitParts[1].equals("+"))
		{
			 result[0]= splitOne[0] + splitTwo[0];
			 result[1]= (splitOne[1]*splitTwo[2])+(splitOne[2]*splitTwo[1]);
			 result[2]= splitOne[2]*splitTwo[2];
		}
		else if (splitParts[1].equals("-"))
		{
			 result[0]= splitOne[0] - splitTwo[0];
			 result[1]= (splitOne[1]*splitTwo[2])-(splitOne[2]*splitTwo[1]);
			 result[2]= splitOne[2]*splitTwo[2];
		}
		else if (splitParts[1].equals("*"))
		{
			result[0]=0;
		   if (splitOne[0]< 0)
		   {
			   splitOne[1]= -1 * splitOne[1];
			   result[1]= ((splitOne[0]*splitOne[2])+splitOne[1])*((splitTwo[0]*splitTwo[2])+ splitTwo[1]);
		   }
		   if (splitTwo[0]<0)
		   {
			   result[1]= (splitOne[0]*splitOne[2]+ splitOne[1])*(splitTwo[0]*splitTwo[2]+ splitTwo[1]);
		   }
		   else result[1]= (splitOne[0]*splitOne[2]+ splitOne[1])*(splitTwo[0]*splitTwo[2]+ splitTwo[1]);
		   result[2]= splitOne[2]*splitTwo[2];
        }
        else if(splitParts[1].equals("/"))
        {
            result[0]=0;
            result[1]= splitTwo[2]*(splitOne[0]*splitOne[2]+splitOne[1]);
            result[2]= splitOne[2]*(splitTwo[0]*splitTwo[2]+splitTwo[1]);
        }
		result[0]= result[0] + result[1]/result[2];
		result[1]= result[1]%result[2];
		
		if (result[0] < 0 && result[1]>0)
		{
			result[0]= result[0]+1;
			result[1]= result[2]-result[1];
			if (result[0]==0)
			{
				System.out.print("-");
			}
		}
		if (result[0]<0 && result[1]<0)
		{
			result[1]= Math.abs(result[1]);
		}
		int factorL = GCF(result[1], result[2]);
		result[1]= result[1]/factorL;
		result[2]= result[2]/factorL;
		if (result[0]==0)
		{
			System.out.println("" + result[1]+"/"+ result[2]);
		}
		else if (result[1]!= 0)
		{
			System.out.println("" + result[0] + "_" + result[1]+"/"+ result[2]);
		}
		else
		{
			System.out.println("" + result[0]);
		}
	}
	public static int[] parseNums(String input)
	{
		int[] parsedNums = new int[3];
		int underscoreLocation = input.indexOf("_");
		if (underscoreLocation != -1)
		{
			parsedNums[0]= Integer.parseInt( input.substring(0, underscoreLocation));	
		}
		else
		{
			parsedNums[0]=0;
		}
		String partTwo = input.substring(underscoreLocation + 1);
		int slashLocation = partTwo.indexOf("/");
		if (slashLocation != -1)
		{
			parsedNums[1]= Integer.parseInt(partTwo.substring(0, slashLocation ));
			parsedNums[2]= Integer.parseInt(partTwo.substring(slashLocation+1));
		}
		else 
		{
			parsedNums[1]=Integer.parseInt(partTwo);
			parsedNums[2]=1;
		}
		return parsedNums;
	}
	public static int GCF(int a, int b) {
		if (b == 0) { 
			return a; 
		} 
		else { 
			return (GCF(b, a % b)); 
		} 
	}
	}

	



