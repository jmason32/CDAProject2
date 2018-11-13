import java.io.*;
import java.util.*;

/*
class Instruction 
{
	public String instr_string; //Full String 
	public int program_counter; // Number in PC
	public String cat; // Category 
	public String opcode; 
	public String source1;
	public String source2;
	public String dest;
	public int imm_value; 
	public String operation;
	public int rt;
	public int rs;
	public String ne4;
	public int target; 

	public Instruction(String instr_string, int program_counter)
	{

		this.instr_string = instr_string;
		this.program_counter = program_counter;
		this.cat = instr_string.substring(0,3);
		this.opcode = instr_string.substring(3,6);
	} 

	public void Ca1()
	{
		if(this.operation == null)
			this.cat = "one";
		else 
		{
			if (this.operation.contains("J"))
			{
				this.imm_value = Integer.parseInt(this.instr_string.substring(6,32),2);
				this.imm_value = imm_value*4; //shift left by 2 same as multiplying by 4


			}
			
			else if (this.operation == "BEQ")
			{
				//if rs = rt then branch
				this.source1 = "R"+Integer.parseInt(this.instr_string.substring(6,11),2);
				this.source2 = "R"+Integer.parseInt(this.instr_string.substring(11,16),2);
				this.imm_value = Integer.parseInt(this.instr_string.substring(16,32),2);
				this.imm_value = imm_value*4;
			}
			
			else if (this.operation == "BNE")
			{
				
				this.source1 = "R"+Integer.parseInt(this.instr_string.substring(6,11),2);
				this.source2 = "R"+Integer.parseInt(this.instr_string.substring(11,16),2);
				this.imm_value = 4*Integer.parseInt(this.instr_string.substring(16,32),2);
			}
			
			else if (this.operation == "BGTZ")
			{
			// : if rs > 0 then branch
				this.source1 = "R"+Integer.parseInt(this.instr_string.substring(6,11),2);
				this.source2 = "R"+Integer.parseInt(this.instr_string.substring(11,16),2); //should come out to be zero 
				this.imm_value = 4*Integer.parseInt(this.instr_string.substring(16,32),2);
				
			}
			
			else if (this.operation == "SW")
			{
				//memory[base+offset] = rt
				this.source1 = "R"+Integer.parseInt(this.instr_string.substring(6,11),2);//base
				this.source2 = "R"+Integer.parseInt(this.instr_string.substring(11,16),2); //rt
				this.imm_value = Integer.parseInt(this.instr_string.substring(16,32),2); //offset
				
			}
			
			else if (this.operation == "LW")
			{
				//rt = memory[base+offset]
				this.source1 = "R"+Integer.parseInt(this.instr_string.substring(6,11),2);//base
				this.source2 = "R"+Integer.parseInt(this.instr_string.substring(11,16),2); //rt
				this.imm_value = Integer.parseInt(this.instr_string.substring(16,32),2); //offset
				
			}
			
			else if (this.operation == "BREAK")
			{
				
			}
		}
	}


	public void Ca2()
	{
		this.cat = "two";
		this.dest = "R"+Integer.parseInt(this.instr_string.substring(6,11),2);
		this.source1 = "R"+Integer.parseInt(this.instr_string.substring(11,16),2);
		this.source2 = "R"+Integer.parseInt(this.instr_string.substring(16,21),2);
	}

	public void Ca3()
	{
		this.cat = "three";
		this.dest = "R"+Integer.parseInt(this.instr_string.substring(6,11),2);
		this.source1 = "R"+Integer.parseInt(this.instr_string.substring(11,16),2);
		this.imm_value = Integer.parseInt(this.instr_string.substring(16,32),2);
	}

	public void Ca4() 
	{
		this.cat = "four";
		this.source1 = "R"+Integer.parseInt(this.instr_string.substring(6,11),2);
		this.source2 = "R"+Integer.parseInt(this.instr_string.substring(11,16),2);
	}

	public void Ca5() 
	{
		this.cat = "five";
		this.dest = "R"+Integer.parseInt(this.instr_string.substring(6,11),2);
	}

	public void CaD()
	{
		//this.imm_value = Integer.parseInt(this.instr_string,2);
		this.imm_value = (int) Long.parseLong(this.instr_string, 2);
	}


	public void getoperation()  
	{
		if (this.cat.contains("one"))

		{
			if(this.opcode.contains("000"))
				this.operation = "J";
			else if (this.opcode.contains("001"))
				this.operation="BEQ";
			else if (this.opcode.contains("010"))
				this.operation="BNE";
			else if (this.opcode.contains("011"))
				this.operation="BGTZ";
			else if (this.opcode.contains("100"))
				this.operation="SW";
			else if (this.opcode.contains("101"))
				this.operation="LW";
			else if (this.opcode.contains("110"))
				this.operation="BREAK";
		}

		else if (this.cat.contains("two"))

		{
			if(this.opcode.contains("000"))
				this.operation = "ADD";
			else if (this.opcode.contains("001"))
				this.operation="SUB";
			else if (this.opcode.contains("010"))
				this.operation="AND";
			else if (this.opcode.contains("011"))
				this.operation="OR";
			else if (this.opcode.contains("100"))
				this.operation="SRL";
			else if (this.opcode.contains("101"))
				this.operation="SRA";
		}

		else if (this.cat.contains("three"))

		{
			if(this.opcode.contains("000"))
				this.operation = "ADDI";
			else if (this.opcode.contains("001"))
				this.operation="ANDI";
			else if (this.opcode.contains("010"))
				this.operation="ORI";
		}

		else if (this.cat.contains("four"))

		{
			if(this.opcode.contains("000"))
				this.operation = "MULT";
			else if (this.opcode.contains("001"))
				this.operation="DIV";
		}

		else if (this.cat.contains("five"))

		{
			if(this.opcode.contains("000"))
				this.operation = "MFHI";
			else if (this.opcode.contains("001"))
				this.operation="MFLO";
		}		
	}

}
*/


class MIPSsim {
	
	enum Category
	{
		ONE,TWO,THREE,FOUR,FIVE,DATA;
	}

	enum Operation
	{
		J,BEQ,BNE,BGTZ,SW,LW,BREAK,ADD,SUB,AND,OR,SRL,SRA,ADDI,ANDI,ORI,MULT,DIV;	
	}

	class Instruction {
		public String full_ins;

		public Category cat;
		public Operation op;

		public int program_counter;
		public String dest;
		public String source1;
	    public String source2;
	    public int imm_value; 

	    //Decided that all instructions will call this 
	    //Others will fill in info if nesscarry 
	    public Instruction(Category cat, String full_ins, int program_counter){
	    	this.cat = cat;
	    	this.full_ins = full_ins;
	    	this.program_counter = program_counter;
	    }

	    public void iOne(){

	    }

	    public void iTwo(Operation op,String dest, String source1, String source2){
	    	this.op = op;
	    	this.dest = dest;
	    	this.source1 = source1;
	    	this.source2 = source2; 
	    }

	}



	//Have a list/
	public void registerPrint(){}

	public String cTr(String sub_string){
		//Takes in a substring and converts to a Register value/name/key
		return "R"+Integer.parseInt(sub_string,2);
	}


	public static void main(String[] args) throws FileNotFoundException {


		String C1 = "000";
		String C2 = "001";
		String C3 = "010";
		String C4 = "011";
		String C5 = "100"; 

		String add,addi,j,mult,mfhi = "000";
		String sub,beq,andi,div,mflo = "001";
		String bne,and,ori = "010";
		String bgtz,or = "011";
		String sw,srl = "100";
		String lw,sra = "101";
		String b = "110";

		//File can be displayed back 
		String file = args[0];
		ArrayList<String> ins=new ArrayList<String>(); //array with string instructions 
		List<Instruction> ins_list = new ArrayList<Instruction>();

		try(Scanner scanner = new Scanner(new FileReader(file))){
			ins.add(scanner.next());
			while (scanner.hasNext()){
				ins.add(scanner.next());
			}
		}
		//Create a collection of instrucion objects 
		//Got through list and set the cat and op

		Iterator<String> insIterator = ins.iterator();
		while (insIterator.hasNext()) {
			String current = insIterator.next();
			//System.out.println(insIterator.next());
			String cat_string = current.substring(0,3);

			switch(cat_string){
				case "000":
					System.out.println(current);
					break;

				case C2:
					System.out.println(current);
					case add: 
						//This is an ADD instruction
						//Instuction needs Cat,binary,PC,OP,D,S1,S2....
						Instruction temp = new Instruction(ONE,current,program_counter);
						temp.iTwo(ADD,cTr(current.substring(6,11)),cTr(current.substring(11,16)),cTr(current.substring(16,21)));
						ins_list.add(temp);	
						
						break;

					case sub:

						break;

					break;

				case C3:
					System.out.println(current);

					break;

				case C4:
					System.out.println(current);

					break;

				case C5:
					System.out.println(current);

					break;
			}

		}
		
	}
}