///////////////////////////////////////////////////////////////////////////////////////////////////
//
//    Customized Database Management System (CDBMS)
//
//    Description:
//        This project implements a customised database management system with the following features:
//        - Creating tables and inserting data into them.
//        - Fetching data from tables, with or without conditions.
//        - Applying aggregate functions like SUM, AVG, MIN, MAX, and COUNT on data.
//        - Deleting records based on specific criteria.
//
//    Technology Used:
//        - Java Programming Language
//        - Collection Framework (LinkedList)
//
//    Key Features:
//        - Replicates the core functionalities of SQL within a Java-based environment.
//        - Allows users to interact with the database through a menu-driven interface.
//        - Helps in understanding the internal working of DBMS and SQL concepts programmatically.
//
//    Author: Gaurav Gavhane  
//    Date: 17 Jan 2025
//
///////////////////////////////////////////////////////////////////////////////////////////////////


import java.util.*;

/////////////////////////////////////////////////////////////////////////////////
//
//  Class Name      :   Employee
//  Description     :   Represents an Employee entity with attributes such as Employee ID (EID), name (Ename), address (EAddress), and salary (ESalary). It maintains a static counter to automatically generate unique EIDs for employees.
//  Note            :   A static counter is used to ensure that each Employee has a unique EID.
//
/////////////////////////////////////////////////////////////////////////////////

class Employee
{
    public int EID; // Unique Employee ID
    public String Ename; // Employee Name
    public String EAddress; // Employee Address
    public int ESalary; // Employee Salary

    private static int Counter; // Counter to auto-increment EIDs

    static
    {
        Counter = 0;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //  Constructor Name:  Employee
    //  Description     :  Initializes Employee details
    //  Query           :  Insert into Employee values(1,"Sagar","Pune",11000);
    //
    /////////////////////////////////////////////////////////////////////////////////
    
    public Employee(String B, String C, int D)
    {
        this.EID = ++Counter; // Auto-increment EID
        this.Ename = B;
        this.EAddress = C;
        this.ESalary = D;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :  DisplayInfo
    //  Description     :  Displays Employee details in a formatted manner
    //
    /////////////////////////////////////////////////////////////////////////////////
    
    void DisplayInfo()
    {
        System.out.println(EID + "\t" + Ename + "\t" + EAddress + "\t" + ESalary);
    }
}

/////////////////////////////////////////////////////////////////////////////////
//
//  Class Name      :   CustomisedDBMS
//  Description     :   Simulates a Database Management System for managing Employee records.
//                      Provides functionality to insert, retrieve, delete, and perform aggregate operations on Employee data.
//
/////////////////////////////////////////////////////////////////////////////////

class CustomisedDBMS
{
    public LinkedList <Employee> lobj; // LinkedList to store Employee objects

    /////////////////////////////////////////////////////////////////////////////////
    //
    //  Constructor Name:  CustomisedDBMS
    //  Description     :  Initializes the DBMS and its data structure
    //
    /////////////////////////////////////////////////////////////////////////////////
    
    public CustomisedDBMS()
    {
        System.out.println("Customised DBMS started successfully...");
        lobj = new LinkedList <Employee>();
    }

    protected void finalize()
    {
        System.out.println("Deallocating all resources of DBMS");
        lobj = null;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :  InsertIntoTable
    //  Description     :  Inserts a new Employee record into the database
    //  Query           :  Insert into Employee values(1,"Sagar","Pune",11000);
    //
    /////////////////////////////////////////////////////////////////////////////////
    
    public void InsertIntoTable(String name, String Address, int Salary)
    {
        Employee eobj = new Employee(name, Address, Salary);
        lobj.add(eobj);
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :  SelectStar
    //  Description     :  Displays all Employee records
    //
    /////////////////////////////////////////////////////////////////////////////////
    
    public void SelectStar()
    {
        System.out.println("Data from the Employee Database: ");
        System.out.println("\n----------------------------------------------------------");
        System.out.println("EID\tEname\t\tEaddress\t\tEsalary");
        System.out.println("----------------------------------------------------------");

        for(Employee eref : lobj)
        {
            eref.DisplayInfo();
        }

        System.out.println("----------------------------------------------------------");
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :  SelectSpecific
    //  Description     :  Displays Employee details for a specific EID
    //
    /////////////////////////////////////////////////////////////////////////////////
    
    public void SelectSpecific(int ID)
    {
        System.out.println("Information of Employee whose EID is: " + ID);

        for(Employee eref : lobj)
        {
            if(eref.EID == ID)
            {
                eref.DisplayInfo();
                break;
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :  SelectSpecific
    //  Description     :  Displays Employee details for a specific Name
    //
    /////////////////////////////////////////////////////////////////////////////////
    
    public void SelectSpecific(String Name)
    {
        System.out.println("Information of Employee whose Name is: " + Name);

        for(Employee eref : lobj)
        {
            if(Name.equals(eref.Ename))
            {
                eref.DisplayInfo();
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :  DeleteFrom
    //  Description     :  Deletes an Employee record by EID
    //
    /////////////////////////////////////////////////////////////////////////////////
    
    public void DeleteFrom(int ID)
    {
        int index = 0;
        boolean bflag = false;

        for(Employee eref : lobj)
        {
            if(eref.EID == ID)
            {
                bflag = true;
                break;
            }
            index++;
        }

        if(!bflag)
        {
            System.out.println("Unable to delete the element from database as given ID is not present");
        }
        else
        {
            lobj.remove(index);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :  DeleteFrom
    //  Description     :  Deletes an Employee record by Name
    //
    /////////////////////////////////////////////////////////////////////////////////
    
    public void DeleteFrom(String Name)
    {
        int index = 0;
        boolean bflag = false;

        for(Employee eref : lobj)
        {
            if(Name.equals(eref.Ename))
            {
                bflag = true;
                break;
            }
            index++;
        }

        if(!bflag)
        {
            System.out.println("Unable to delete the element from database as given name is not present");
        }
        else
        {
            lobj.remove(index);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :  AggregateSum
    //  Description     :  Calculates and displays the sum of all Employee salaries
    //
    /////////////////////////////////////////////////////////////////////////////////
    
    public void AggregateSum()
    {
        int iSum = 0;

        for(Employee eref : lobj)
        {
            iSum += eref.ESalary;
        }

        System.out.println("Summation of salary: " + iSum);
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :  AggregateMax
    //  Description     :  Displays the maximum salary among all Employees
    //
    /////////////////////////////////////////////////////////////////////////////////
    
    public void AggregateMax()
    {
        int iMax = 0;

        for(Employee eref : lobj)
        {
            if(eref.ESalary > iMax)
            {
                iMax = eref.ESalary;
            }
        }

        System.out.println("Maximum salary: " + iMax);
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :  AggregateMin
    //  Description     :  Displays the minimum salary among all Employees
    //
    /////////////////////////////////////////////////////////////////////////////////
    
    public void AggregateMin()
    {
        Employee temp = lobj.get(0);

        int iMin = temp.ESalary;

        for(Employee eref : lobj)
        {
            if(eref.ESalary < iMin)
            {
                iMin = eref.ESalary;
            }
        }

        System.out.println("Minimum salary: " + iMin);
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :  AggregateAvg
    //  Description     :  Displays the average salary of all Employees
    //
    /////////////////////////////////////////////////////////////////////////////////
    
    public void AggregateAvg()
    {
        int iSum = 0;

        for(Employee eref : lobj)
        {
            iSum += eref.ESalary;
        }

        System.out.println("Average salary: " + (iSum / lobj.size()));
    }

    /////////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name   :  AggregateCount
    //  Description     :  Displays the total count of Employees
    //
    /////////////////////////////////////////////////////////////////////////////////
    
    public void AggregateCount()
    {
        System.out.println("Number of Employees: " + lobj.size());
    }
}

/////////////////////////////////////////////////////////////////////////////////
//
//  Class Name      :   EmpDBMS
//  Description     :   Provides a menu-driven interface for various operations on the database
//
/////////////////////////////////////////////////////////////////////////////////

class EmpDBMS
{
    public static void main(String Arg[])
    {
        System.out.println("-------- Customised Database Management System --------");

        Scanner sobj = new Scanner(System.in);

        CustomisedDBMS mobj = new CustomisedDBMS();

        int iOption = 0;
        int Salary;
        int EID;

        String Name;
        String Address;

        while(true)
        {
            System.out.println("----------------------------------------------------------");
            System.out.println("Please select your choice based on your requirement: ");
            System.out.println("----------------------------------------------------------");

            System.out.println("1 : Insert new record into the table");
            System.out.println("2 : Display all records");
            System.out.println("3 : Display all records having specific EID");
            System.out.println("4 : Display all records having specific Name");
            System.out.println("5 : Delete the record based on EID");
            System.out.println("6 : Delete the record based on Employee name");
            System.out.println("7 : Display Sum of all salary");
            System.out.println("8 : Display Average of all salary");
            System.out.println("9 : Display Minimum from all salary");
            System.out.println("10 : Display Maximum from all salary");
            System.out.println("11 : Display the Count of records");
            System.out.println("12 : Display Help");
            System.out.println("13 : Display About");
            System.out.println("14 : Terminate the DBMS");
            System.out.println("----------------------------------------------------------");

            iOption = sobj.nextInt();

            switch(iOption)
            {
                case 1 : 
                    System.out.println("Please enter the information of employee: ");

                    System.out.println("Please enter Employee name: ");
                    sobj.nextLine();
                    Name = sobj.nextLine();

                    System.out.println("Please enter Employee Address: ");
                    Address = sobj.nextLine();

                    System.out.println("Please enter Employee Salary: ");
                    Salary = sobj.nextInt();

                    mobj.InsertIntoTable(Name, Address, Salary);

                    break;

                case 2 : 
                    mobj.SelectStar();
                    break;

                case 3 : 
                    System.out.println("Please enter the Employee ID whose information you want to display: ");
                    EID = sobj.nextInt();
                    mobj.SelectSpecific(EID);
                    break;

                case 4 : 
                    System.out.println("Please enter the Employee name whose information you want to display: ");
                    sobj.nextLine();
                    Name = sobj.nextLine();
                    mobj.SelectSpecific(Name);
                    break;

                case 5 : 
                    System.out.println("Please enter the Employee ID whose information you want to delete: ");
                    EID = sobj.nextInt();
                    mobj.DeleteFrom(EID);
                    break;

                case 6 : 
                    System.out.println("Please enter the Employee name whose information you want to delete: ");
                    sobj.nextLine();
                    Name = sobj.nextLine();
                    mobj.DeleteFrom(Name);
                    break;

                case 7 : 
                    mobj.AggregateSum();
                    break;

                case 8 : 
                    mobj.AggregateAvg();
                    break;

                case 9 : 
                    mobj.AggregateMin();
                    break;

                case 10 : 
                    mobj.AggregateMax();
                    break;  

                case 11 : 
                    mobj.AggregateCount();  
                    break;    

                case 12 : 
                    System.out.println("This project implements the DBMS for employee records");
                    System.out.println("We implement all SQL queries");
                    System.out.println("All data gets stored in Data structres");
                    System.out.println("Complete implemenrtation is on Primary storage");
                   
                    break;

                case 13 : 
                    System.out.println("This project developed by Gaurav Gavhane");
                    System.out.println("All copyrights reserved..");

                    break;
                    
                case 14 : 
                    System.out.println("Thank you for using the customised DBMS");
                    mobj = null;

                    System.gc();

                    System.exit(0);           
            }
        }
        
    }
}

