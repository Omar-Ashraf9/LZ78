import java.util.Scanner;
import java.util.HashMap; 
import java.util.*;
public class compression_decompression 
{
	public static int t;
	
	public static void compression()
	{
		Scanner in = new Scanner(System.in);
		String input;
		
		System.out.println("Enter the message that you want to compress: ");
		input = in.nextLine();
		Vector indexOfDic = new Vector();
        Vector valueOfDic = new Vector();

        Vector indexOfTag = new Vector();
        Vector valueOfTag = new Vector();

        indexOfDic.add(0);
        valueOfDic.add("---");
        int Count = 0;
        String temp = new String();
        temp = "";


        for(int i = 0; i < input.length(); i++)
        {
            temp += input.charAt(i);
            if(!valueOfDic.contains(temp))
            {
                Count++;
                indexOfDic.add(Count);
                valueOfDic.add(temp);
               
                // for tag
               
                if(temp.length() == 1)
                {
                    indexOfTag.add(0);
                    valueOfTag.add(temp);
                }else
                {
                    String to_tag = temp.substring(temp.length() - 1);
                    indexOfTag.add(t);
                    valueOfTag.add(to_tag);
                }
                temp = "";
            }else
            {
                int x = valueOfDic.indexOf(temp);
                t = (int)indexOfDic.get(x);
            }
            if(temp.length() == 1 && i == input.length()-1) 
            {
                indexOfTag.add(t);
                valueOfTag.add("null");
            }


        }
        	
        	for(int i = 0; i < indexOfTag.size(); i++)
        	{
        		System.out.println("< " + indexOfTag.get(i) + " , " + valueOfTag.get(i) + " >");
        	}
	}
	
	public static void decompression()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of tags: ");
		
		int num_of_tags;
		num_of_tags = in.nextInt();
		
		System.out.println("Enter the tags that you want to decompress it in this order:  index , next symbol.");
		
		String next_symbol;
		int index;
		Vector<Integer> indexOfTag = new Vector<Integer>();
		Vector<String> valueOfTag = new Vector<String>();
		
		Vector<Integer> indexOfDic = new Vector<Integer>();
		Vector<String> valueOfDic = new Vector<String>();
		int Count = 0;
		indexOfDic.add(0);
        valueOfDic.add("---");
		/// Take tags from user.
        while(num_of_tags != 0)
		{
			index = in.nextInt();
			next_symbol = in.nextLine();
			indexOfTag.add(index);
			valueOfTag.add(next_symbol);
			num_of_tags--;
		}
		
        String result = "";
        String temp = "";
        
		for(int i = 0; i < indexOfTag.size(); i++)
		{
			 
			 if(valueOfTag.get(i).equals(" null"))
			{
				temp += valueOfDic.get(indexOfTag.get(i));
				result += temp;
				temp = "";
			}
			
			else if(indexOfTag.get(i) == 0)
			{
				Count++;
				indexOfDic.add(Count);
				temp = valueOfTag.get(i);
				valueOfDic.add(temp);
				result += temp;
				temp = "";
			}
			else
			{
				temp += valueOfDic.get(indexOfTag.get(i));
				temp += valueOfTag.get(i);
				Count++;
				indexOfDic.add(Count);
				valueOfDic.add(temp);
				result += temp;
				temp = "";
			}
		}
		
		System.out.println("The message after decompression is: " + result);
		for(int i = 0; i < indexOfDic.size(); i++)
    	{
    		System.out.println(indexOfDic.get(i) + " - " + valueOfDic.get(i));
    	}
	}
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int choice;
		boolean work = true;
		while(work)
		{
			System.out.println("if you want to compress message please press 1 \npress 2 to decompress \nwhen you finish please enter 0:  ");

			choice = in.nextInt();
			if(choice == 1)
			{
				compression();
			}
			else if(choice == 2)
			{
				decompression();
			}else if(choice == 0)
			{
				System.out.println("Thank you, regarsds");
				work = false;
			}else
			{
				System.out.println("Invalid input");
			}
			
			
		}
		
	}
		
		
}
