package routerrental_package;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/** Class Router contains all the details related to the a single router
 * Implements Comparable interface to allow the comparison between two routers. 
 * contains final variables 
 * model: the model of the router (eg SmartStart LTE Router)
 * noPorts: Serial number of the router 
 * serialNo: Serial number of the router
 * pricePerDay: price of renting this router for a day (unit. L.E.)
 * totalRouters: static variable represent the total number of routers 
 * feedback: Arraylist contains any feedback or report that a customer give to this router
 * reservedBefore: boolean variable represents if this router was reserved before or not
 */
 class Router implements Comparable<Router>
{
    /** the model of the router (e.g. SmartStart LTE Router) */
    private String model;
    /** Number of ports in the router */
    private final int noPorts;
    /** Serial number of the router */
    private final int serialNo;
    /** price of renting this router for a day (unit. L.E.) */
    private double pricePerDay;
    /** static variable represent the total number of routers */
    private static int totalRouters = 0;
    /** Arraylist contains any feedback or report that a customer give to this router */
    private ArrayList<String> feedback;
    /** boolean variable represents if this router was reserved before or not */
    private boolean reservedBefore;
    
    /**
     * Router constructor #1
     * Constructor is called when creating new object from this class
     * What needs to be done when creating a new object from Router class?
     * - increase the 'totalRouters' static variable by 1
     * - initialize variables related to this router ( model, noPorts, pricePerDay)
     * - define the serial number to this router (dynamically)
     * - declare the 'feedback' arraylist.
     * @param model model of the router
     * @param noPorts number of ports in the router
     * @param pricePerDay price of renting for one day
     */
    public Router(String model, int noPorts, double pricePerDay)
    {
        totalRouters++;
        this.model = model;
        this.noPorts = noPorts;
        this.pricePerDay = pricePerDay;
        serialNo = totalRouters + 1000;
        reservedBefore= false;
        feedback = new ArrayList<>();
    }
        
    /**
     * Router constructor #2
     * Constructor is called when creating new object from this class
     * What needs to be done when creating a new object from Router class?
     * - increase the 'totalRouters' static variable by 1
     * - initialize variables related to this router ( model, noPorts, pricePerDay)
     * - pricePerDay will be the default value = 50
     * - define the serial number to this router (dynamically)
     * - declare the 'feedback' arraylist.
     * @param model model of the router
     * @param noPorts number of ports in the router
     */
    public Router(String model, int noPorts)
    {
        totalRouters++;
        this.model = model;
        this.noPorts = noPorts;
        this.pricePerDay = 50;
        serialNo = totalRouters + 1000;
        reservedBefore= false;
        feedback = new ArrayList<>();
    }
    /**
     * Display the details of the router in the console.
     */
    public final void displayRouterData() {
       System.out.println("Router Serial Number:" + serialNo);
       System.out.println("\tRouter Name:" + model);
       System.out.println("\tRouter noPorts:" + noPorts);
       System.out.println("\tRouter price/day:" + pricePerDay);
       System.out.println("\tRouter #feedbacks:" + feedback.size()); 
       for(int i= 0; i< feedback.size(); i++)
       {
           System.out.println("\t\tfeedback["+i+"] "+ feedback.get(i));
       }
    }
    /**
     * Compares this router to anther router passed to the function through a parameter 
     * the compression depends on the number of the ports
     * implemented as overriden function to 'Comparable' interface  
     * @param r 
     * @return 1 if this router has number
     */
     @Override
    public int compareTo(Router r)
    {
        if(this.noPorts==r.noPorts)  
            return 0;  
         else if(this.noPorts>r.noPorts)  
            return 1;  
         else  
            return -1;  
    }
    /**
     * 
     * @return reference points at Arraylist that contains all feedbacks/reports to this router 
     */
    public ArrayList<String> getFeedback() {
        return feedback;
    }
    /**
     * Static method to get the total number of routers
     * @return total number of routers
     */
    public static int noRouters()
    {
        return totalRouters;
    }
   /**
    * instance function returns the model of this router
    * @return the model of this router
    */
    public String getModel() {
        return model;
    }
/**
 * instance function returns the number of ports in this router
 * @return the number of ports in this router
 */
    public int getNoPorts() {
        return noPorts;
    }
/**
 * instance function returns the price of renting this router for one day 
 * @return the price of renting this router for one day 
 */
    public double getPricePerDay() {
        return pricePerDay;
    }
/**
 * instance function returns  the serial number of this router
 * @return the serial number of this router
 */
    public int getSerialNo() {
        return serialNo;
    }
/**
 * instance function returns true: if this router was reserved before, false: otherwise 
 * @return true: if this router was reserved before, false: otherwise 
 */
    public boolean isReservedBefore() {
        return reservedBefore;
    }
/**
 * Change the price of renting this router for one day to the given value passed through parameter
 * @param pricePerDay the new value of price
 */
    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
/**
 * Change 'reservedBefore' variable to the given value passed through parameter
 * @param reservedBefore the new value
 */
    public void setReservedBefore(boolean reservedBefore) {
        this.reservedBefore = reservedBefore;
    }
}
/**
 * Reservation class contains details about dates (reserveDate, startDate, endDate), type 'duration' of the reservation , number of days, available routers at this duration 
 *   totalReservations: static variable represents the total number of reservation 
 *   reserveNo: distinct number to mark each reservation
 *   reserveDate: the date of reservation
 *   startDate: the first date in renting
 *   endDate: the last date in renting
 *   type: the duration of renting in string format:  'd':: one day, 'w':: one week, 'm':: one month
 *   availRouter: Arraylist contains all routers available in this duration, changes if the duration of reservation is extend
 *   noDays:  the duration of renting in integer format:
 */

 class Reservation
{
    /** static variable represents the total number of reservation  */
    private static int totalReservations  = 0;
    /** distinct number to mark each reservation */
    private final int reserveNo;
    /**  the date of reservation */
    private Date reserveDate;
    /**  the first date in renting */
    private Date startDate;
    /** the last date in renting */
    private Date endDate;
    /** the duration of renting in string format:  'd':: one day, 'w':: one week, 'm':: one month */
    private String type;
    /**  Arraylist contains all routers available in this duration, changes if the duration of reservation is extend */
    private List<Integer> availRouter = new ArrayList();
    /** the duration of renting in integer format: */
    private int noDays= 0;
    /**
     * Reservation constructor 
     * Constructor is called when creating new object from this class
     * What needs to be done when creating a new object from reservation class?
     * - increase the `totalReservations` static variable by 1
     * - initialize variables (reserveDate, startDate, type)
     * - set a unique number to be used to mark this reservation (reserveNo)
     * - calculate dynamically the endDate (last date of renting)
     * 
     * @param reserveDate the date of reservation 
     * @param startDate the first date of renting
     * @param type the duration of renting in string format
     */
    public Reservation(Date reserveDate, Date startDate, String type) {
        totalReservations++;
        this.reserveDate = reserveDate;
        this.startDate = startDate;
        this.type = type;
        reserveNo = totalReservations;
        if (type.equals("d"))
        {   endDate = this.startDate; noDays +=1;
        }else if (type.equals("w"))
        {   Calendar calender = Calendar.getInstance();
            calender.setTime(startDate);
            calender.add(Calendar.DAY_OF_YEAR, 7);
            endDate = calender.getTime(); noDays +=7;
        }
        else if (type.equals("m"))
        {   Calendar calender = Calendar.getInstance();
            calender.setTime(startDate);
            calender.add(Calendar.MONTH, 1);
            endDate = calender.getTime(); noDays +=30;
        }
    }
/**
 * change the number of days to the given value
 * @param noDays the new value
 */
    public void setNoDays(int noDays) {
        this.noDays = noDays;
    }
/**
 * instance value returns  the number of days for this reservation
 * @return the number of days for this reservation
 */
    public int getNoDays() {
        return noDays;
    }
    /**
     * instance value returns a reference points at the available Routers in this duration 
     * @return reference points at the available Routers in this duration 
     */
    
    public List<Integer> getAvailRouter() {
        return availRouter;
    }
    /**
     * Change the content of 'availRouters' to the new list passed through the parameter
     * @param availRouter the new list
     */
    public void setAvailRouter(List<Integer> availRouter) {
        this.availRouter = availRouter;
    }
    /**
     * static method return the total number of reservations
     * @return total number of reservation happened
     */
    public static int getTotalReservations() {
        return totalReservations;
    }
    /**
     * instance value returns this reservation number 
     * @return this reservation number 
     */
    public int getReserveNo() {
        return reserveNo;
    }
    /**
     * instance value returns this reservation Date
     * @return this reservation Date
     */
    public Date getReserveDate() {
        return reserveDate;
    }
    /**
     * instance value returns the start date for this reservation 
     * @return the start date for this reservation 
     */
    public Date getStartDate() {
        return startDate;
    }
    /**
     * instance value returns  the last date for this reservation 
     * @return the last date for this reservation 
     */
    public Date getEndDate() {
        return endDate;
    }
    /**
     * Change the last date for this reservation (in case somebody extends the rent)
     * @param endDate the new date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    /**
     * instance value returns the type of this duration
     * @return return the type of this duration
     */
    public String getType() {
        return type;
    }
    /**
     * Change the type of this reservation when extending the rent
     * @param type  the new value
     */
    public void setType(String type) {
        this.type = type;
    }
    
}
/**
 * Invoice Class contains everything (Reservation object, Router object, Customer object)
 * Reservation object is called 'reserve',It contains variables and methods about the dates, duration and available routers to this invoice
 * Router object is called 'router',It is the router selected to be rent in this invoice
 * Customer Reference is called 'person', It is the customer that rent and reserved this invoice (At runtime, polymorphism plays it's role to decide if this will be a resident object or foreigner object)
 * fees total fees.
 */
 class Invoice 
{
    /** It contains variables and methods about the dates, duration and available routers to this invoice */
    private Reservation reserve;
    /**It is the router selected to be rent in this invoice  */
    private Router router;
    /** It is the router selected to be rent in this invoice */
    private  Customer person;
    /**total fees.*/
    private double fees;
    /**
     * Invoice Constructor
     * Constructor is called when creating new object from this class
     * What needs to be done when creating a new object from Invoice class?
     * - initialize/instantiate the three objects
     * @param rev reservation
     * @param r router
     * @param c customer
     */
    public Invoice(Reservation rev, Router r, Customer c)
    {
        this.reserve = rev;
        this.router = r;
        this.person = c;
    }
    /**
     * this method is inherited from class java.lang.Object
     * it is overridden to print a statement into console when destroying this object
     * It's used to cancel the reservation 
     */
    @Override
    public void finalize() 
    { 
        System.out.println("this invoice has been canceled"); 
    } 
    /**
     * this function is used to extend the reservation for a day/week/month 
     * it takes from the user a char 'd' for a day, 'w' for a week, 'm'for a month
     * and extends the duration depending on its value
     * It also changes reserve.endDate
     * @param newType a char 'd' for a day, 'w' for a week, 'm'for a month represents the duration of the extension 
     */
    public void extend(String newType)
    {
        Calendar calender = Calendar.getInstance();
        calender.setTime(reserve.getEndDate());
        if (newType.equals("d"))
        {   calender.add(Calendar.DAY_OF_YEAR, 1);
            reserve.setEndDate(calender.getTime());
            reserve.setType(reserve.getType()+",d");  reserve.setNoDays(getReserve().getNoDays()+1);
        }else if (newType.equals("w"))
        {   calender.add(Calendar.DAY_OF_YEAR, 7);
            reserve.setEndDate(calender.getTime());
            reserve.setType(reserve.getType()+",w"); reserve.setNoDays(getReserve().getNoDays()+7);
        }
        else if (newType.equals("m"))
        {   calender.add(Calendar.MONTH, 1);
            reserve.setEndDate(calender.getTime());
            reserve.setType(reserve.getType()+",m"); reserve.setNoDays(getReserve().getNoDays()+30);
        }
        
    }
    /**
     * Change the router to the new given router
     * @param newRouter the new router
     */
    public void changeModel(Router newRouter)
    {
       this.router = newRouter;
        
    }
    /**
     * this methods add a new feedback/report to the router's feedback arraylist
     * @param msg string contains the msg to be added to the arraylist
     */
    public void feedback(String msg)
    {
        router.getFeedback().add(msg);
    }
    /**
     * Calculate the total fees for this resevation depends on the type of customer
     * residents has 0.25 discount, foreigners has no discount
     */
    public void calculatefees()
    {
        if (person instanceof Resident)
        {
         double price = router.getPricePerDay() * reserve.getNoDays();
         price *= 0.75;
         fees = price;
        }else { // Foregienr
         fees = router.getPricePerDay() *  reserve.getNoDays();
        }
    }
/**
 * instance function returns a reference points at this invoive's reservation 
 * @return reference points at this invoive's reservation 
 */
    public Reservation getReserve() {
        return reserve;
    }
/**
 * instance function returns a reference points at this invoice's router
 * @return reference points at this invoice's router
 */
    public Router getRouter() {
        return router;
    }
/**
 * instance function returns a reference points at the customer of this invoice
 * @return reference points at the customer of this invoice
 */
    public Customer getPerson() {
        return person;
    }
/**
 * instance function returns the total fees for this invoice
 * @return the total fees for this invoice
 */
    public double getFees() {
        return fees;
    }
    
    
}

/**
 * customer is an abstract class, that contains all common variables and methods that used in both cases (Resident/Foreigner)
 * Variables inside the class.
 * totalCustomers: static variable represents the total number of customers
 * noCustomer: unique number used to distinguish this customer (Only the customer knows this number) as it's used with password to login to the program 
 * name: Customer name
 * pass: Customer password
 * reservedBefore: boolean variable represents if that customer reserved any router before of not
 * @author user
 */
  abstract class Customer
{
     /** static variable represents the total number of customers */
     static int totalCustomers = 0;
    /** unique number used to distinguish this customer (Only the customer knows this number) as it's used with password to login to the program  */
      final int noCustomer;
    /**  Customer name */
      String name;
    /** Customer password */
      String pass;
    /** boolean variable represents if that customer reserved any router before of not */
      boolean reservedBefore;
    /**
     * Customer constructor 
     * Constructor is called when creating new object from this class
     * What needs to be done when creating a new object from Customer class?
     * - increase the `totalCustomers` static variable by 1
     * - initialize variables (name, pass)
     * - dynamically initialize reserved before as false
     * - define a unique number to this customer (noCustomer)
     */
    public Customer(String name, String pass) {
        this.name = name;
        this.pass = pass;
        reservedBefore = false;totalCustomers++;
        noCustomer = totalCustomers;
    }
/**
 * 
 * @return the unique number of this customer 
 */
    public int getNoCustomer() {
        return noCustomer;
    }
/**
 * static function returns the total number of customers 
 * @return the total number of customers 
 */
    public static int getTotalCustomers() {
        return totalCustomers;
    }
/**
 * instance function returns this customer name 
 * @return this customer name 
 */
    public String getName() {
        return name;
    }
/**
 *  instance function returns this customer password
 * @return 
 */
    public String getPass() {
        return pass;
    }
/**
 *  instance function return a true if this customer reserved a rent before, else zero
 * @return  a true if this customer reserved a rent before, else zero
 */
    public boolean isReservedBefore() {
        return reservedBefore;
    }
/**
 * change 'reservedBefore' boolean variable to the given value
 * @param reservedBefore the new value
 */
    public void setReservedBefore(boolean reservedBefore) {
        this.reservedBefore = reservedBefore;
    }
       
}
/**
 * Resident class extends Customer class, It contains the variables related to Residents only
 * Variables:
 * noID: the national ID of this resident
 */
 class Resident extends Customer
{
    /** the national ID of this resident */
     String noID;
    /**
     * Resident Constructor 
     * Constructor is called when creating new object from this class
     * What needs to be done when creating a new object from Resident class?
     * - call the super constructor (Customer)
     * - initialize noID variable 
     * @param name customer name, will be sent to the super class
     * @param pass customer password, will be sent to the super class
     * @param noID  customer national ID
     */
    public Resident(String name, String pass, String noID) {
        super(name, pass);
        this.noID = noID;
    }

}
/**
 * Foreigner class extends customer class, It contains the variable related to Foreigners only
 * variable:
 * noPassport: the passport number of this customer
 * @author user
 */
 class Foreigner extends Customer 
{
    /**the passport number of this customer */
     String noPassport;
    /**
     * Foreigner Constructor
     * Constructor is called when creating new object from this class
     * What needs to be done when creating a new object from Foreigner class?
     * - call the super constructor (Customer)
     * - initialize noPassport variable 
     * @param name customer name, will be sent to the super class
     * @param pass customer password, will be sent to the super class
     * @param noPassport customer passport number
     */
    public Foreigner(String noPassport, String name, String pass) {
        super(name, pass);
        this.noPassport = noPassport;
    }
    
}
/**
 * RouterRental Class contains main function 
 * The class contains 3 arraylists 
 * customers: contains both residents and foreigners
 * routers: contains routers with different models 
 * Invoice: contains all invoices 
 * The main function tests and calls all the other function 
 * all required functionalities has been applied and test 
 * 
 * all the following concepts has been applied in this program
1. Inheritance tree(s)
* the relation between resident and foreigner is inheritance. the customer class is the super class for both of the 2 classes (resident and foreigner). 
* on other words, both resident and foreigner extends the customer class
2. Polymorphism and Overloading
* In run time, the program determines the type of customer depending on the user input. there is one reference called 'person' that will points at resident or foreigner object 
3. Overriding. overloading is in Router Class (Constructor Overloading)
* to cancel a reservation, this reservation object will be removed. 
* It has been implemented by overridden finalize method to display an statement before removing the object.
* also overriding has been used in comapreTo method inside comparable interface, that router class implements to give the user the ability to compare two routers 
4. Abstract class
* Customer class is an abstract class. 
5. Interface(s)
* Router class implements the build-in comparable interface that is used to compare two objects with each others
6. Final data member(s)
* final data members are used when the value of these variables are constant and won't be changed, These variables are (noPorts) that represents 
* the number of ports that a router has, (Serialno) the serial number for a router, (resereNo)  the unique number that distinguish a reservation,
* (noCustomer) the unique number that distinguish a customer
7. Final method(s)
* (displayRouterData) function inside Router are final to prevent overriding
8. Static data member(s)
* Static data members are variables used on the level of the class not object. I used this variables to discover the total numbers of objects e.g.
* (totalRouters) in Router Class, (totalReservations) in Reservation Class and (totalCustomers) in Customer class.
* Other usage of static data members was in RouterRental Class to use in inside the static methods like main method
9. Static method(s)
* to operate with static members, you need static methods. (noRouters) static method inside Router class to get the totalRouters static member.
* (getTotalCustomers) static method inside Router class is used to get the totalCustomers static member.
* (getTotalReservations) static method inside Router class is used to get the totalReservations static member.
* also in RouterRental Class the main, availRoutersAtThisDuration and displayandChooseRouterAvailble are static methods
10. Exception handling (Both Java defined exception(s) and your own defined exception object(s))
* I.  Java defined exception
* ParseException: when parsing from string to date fails 
* II. your own defined exception 
* 3 classes (CancelRentException, InvalidAccessException, InvalidInputException) extend exception class.
* CancelRentException:  if the customer cancels the reservation before the start date in less than 2 days 
* InvalidAccessException: if the not-owner customer tries to edit a rent
* InvalidInputException: if the customer enters invalid input
* the 3 classes are thrown in main Function
11. Different Access modifiers should be used throughout the project as needed.
* Members in Router, Reservation and invoice are Private due to privacy, They can be accessed through getter, some of them can be updated through setter.
* Members in Customer are package(default), to allow the children of this class operate with its members 
12. Calculated data members
* fees in invoice class, type in reservation class
13. Apply at least one of the SOLID object-oriented design principles
Single Responsibility principle: 'A class should have one and only one reason to change'
* that principle has been applied in all classes, each class has a certain job,
* Router Class represents the information needed for a single router (serailnumber, number of ports, models, ...)
* Reservation Class represents the information needed to make a reservation (dates, durations, available routers, ...)
* Customer Class contains all information about the customer
* Invoice Class contains all information and operation related to the invoice.
Liskov Substitution principle: 'Derived Classes should not change the behavior of the base class '
* (Resident and foreigner) the derived classed from (Customer) base class don't change the behavior of the base class
* they just giving us more information and abilities to the customer
Interface Segregation principle: 'Classes that implement interfaces, should not be forced to implement methods they don't use '
* The Router class implements comparable interface that contains the methods required for router class
* Class Router didn't proved any extra implementation to extra non-required methods. 
Dependency Inversion principle
 */

public class RouterRental {

/**  contains both residents and foreigners */
    private static ArrayList<Customer> customers = new ArrayList<>();
    /**  contains routers with different models  */
   private  static ArrayList<Router> routers = new ArrayList<>();
    /**  contains all invoices */
    private static ArrayList<Invoice> invoices = new ArrayList<>();
    
    /**
     * The main function contains hard coded example and runtime interaction with the user
     * 
     * @param args
     * @throws CancelRentException  if the customer cancels the reservation before the start date in less than 2 days 
     * @throws InvalidAccessException if the not-owner customer tries to edit a rent
     * @throws InvalidInputException  if the customer enters invalid input
     */
    public static void main(String[] args) throws CancelRentException, InvalidAccessException, InvalidInputException{
        // declaration of scanner and date format
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        ///// initializing hard-coded input data
        // initializing dates
        String sdate1 = "1-1-2020", sdate2 = "4-2-2020", sdate3 = "6-6-2020";
        Date date1=null, date2=null, date3=null;
        try {
            //Parsing the String
            date1 = dateFormat.parse(sdate1);
            date2 = dateFormat.parse(sdate2);
            date3 = dateFormat.parse(sdate3);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // initializing routers 
        Router r1 = new Router("SmartStart LTE Router", 4, 30);   
        Router r2 = new Router("SmartStart LTE Router", 8, 60);  
        Router r3 = new Router("SmartFlex LTE Router", 4, 25);        
        Router r4 = new Router("SmartFlex LAN Router", 6, 34);   
        Router r5 = new Router("SmartStart LTE Router", 4, 18.99);  
        Router r6 = new Router("ICR-3800 Railway LTE Router", 8, 56.5);
        // adding routers to the arraylist
        routers.add(r1); routers.add(r2); routers.add(r3); routers.add(r4); routers.add(r5); routers.add(r6);
        
        // instanciating customers 
        Customer  resident1 = new Resident("Ahmed", "123", "202011");
        Customer  resident2 = new Resident("Aya", "456", "20011");
        
        Customer  foreigner1 = new Foreigner("Sinan", "789", "999120");
        Customer  foreigner2 = new Foreigner("George", "111", "888170");
        // creating reservations (the first reservation for resident1 customer, he rents r1 router for a day )
        Reservation reservation1resident1r1 = new Reservation(date1, date2, "d");
        r1.setReservedBefore(true);
        Invoice invoiceRent1 = new Invoice(reservation1resident1r1, r1, resident1);
        invoices.add(invoiceRent1);
        invoiceRent1.calculatefees();
        // creating reservations (the second reservation for resident1 customer, he rents r2 router for a week  )
        Reservation reservation2resident1r2 = new Reservation(date1, date2, "w");
        r2.setReservedBefore(true);
        Invoice invoiceRent2 = new Invoice(reservation2resident1r2, r2, resident1);
        invoices.add(invoiceRent2);
        invoiceRent2.calculatefees();
        // creating reservations (the first reservation for foreigner1 customer, he rents r1 router for a week )
        Reservation reservation1Foregienerr1 = new Reservation(date2, date3, "w");
        r1.setReservedBefore(true);
        Invoice invoiceRent3 = new Invoice(reservation1Foregienerr1, r1, foreigner1);
        invoices.add(invoiceRent3);
        invoiceRent3.calculatefees();
        
        // run-time data input
         /** today will be used to get the day of reservation*/
        Date today;
        /** person is a reference points at the active customer in the program */
        Customer person = null; 
        System.out.println("Welcome to RouterRental program\nplease enter today, format (dd-mm-yyyy)");
        // getting the value of 'today' 
        String str = scanner.next();
        today =null;
        try {
            //Parsing the String
            today = dateFormat.parse(str);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int choice;
        while(true)
        {
        System.out.println("press \n[0] to sign in\n[1] to sign up\n[2]exit");
        choice = scanner.nextInt();
        if(choice == 0) // sign in 
        {
            int customerNo; String pass;
            System.out.println("Please enter your customer number"); customerNo = scanner.nextInt();
            System.out.println("Please enter your password"); pass = scanner.next();
            boolean found = false;
            // searching all the customers
            for (int i = 0; i< customers.size(); i++)
            {
                if (customers.get(i).getNoCustomer()==customerNo &&customers.get(i).getPass().equals(pass))
                {found = true; person = customers.get(i); break;}
            }
            if(found == false)
                System.out.println("your customer number/ password is wrong");

        }else if (choice == 1) // sign up 
        {
            // polymorphism plays its role here
            System.out.println("press\n[0] if you're resident\n[1] if you're foreigner"); int c = scanner.nextInt();
            System.out.println("please enter your name"); String name = scanner.next();
            System.out.println("please enter your password"); String pass = scanner.next();
            
            if (c == 0) //resident
            { // adding the new customer to the customers arraylist
                System.out.println("please enter your id"); String id = scanner.next();
                person = new Resident(name, pass, id);
                customers.add(person);
                System.out.println("Your account is created, you customer number is " + person.getNoCustomer()+ " remeber it well");

            }
            else if(c == 1)
            { // adding the new customer to the customers arraylist
                System.out.println("please enter your passport"); String passport = scanner.next();
                person = new Foreigner(name, pass, passport);
                customers.add(person);
                System.out.println("Your account is created, you customer number is " + person.getNoCustomer()+ " remeber it well");


            }
            else {//invalid input in this condintion press[0] if you're resident\n\t[1] if you're foreigner
                throw new InvalidInputException();
            }            
        }else if (choice == 2) // exit
        {
            System.out.println("Goodbye, please be back soon");
            break;
        }else { //invalid input in this condintion press [0] to sign in\n[1] to sign up
           throw new InvalidInputException();
        }

        if (person != null) 
        {
            while (true)
            {
                System.out.println("Welcome, press\n[0] to rent\n[1] to display all data\n[2]Change today date\n[3]compare 2 routers\n[4]logout");
                choice = scanner.nextInt();

                if (choice == 0) // rent
                {// getting the required data from the user
                    Date startDate; String type; Router r = null; person.setReservedBefore(true);
                    System.out.println("Reservation date is " + today);
                    System.out.println("Enter start date");
                    str = scanner.next();
                    startDate =null;
                    try {
                        //Parsing the String
                        startDate = dateFormat.parse(str);
                        while (!startDate.after(today))
                        {
                            System.out.println("Invalid input!! the start day can't be the same day or before the date of reservation.");
                            System.out.println("Enter start date");
                            str = scanner.next();
                            startDate =null;
                            startDate = dateFormat.parse(str);

                        }
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("Enter rent type ['d','w','m']");
                    type = scanner.next();
                    // creating reseravation object
                    Reservation res = new Reservation(today, startDate, type);
                    // getting the routers that are available in this duration 
                    System.out.println("Router available at this duration: ");
                    // calling anthor function in the same class 
                    availRoutersAtThisDuration(res);         
                    int serial=displayandChooseRouterAvailble(res);
                    for(int i = 0; i < routers.size(); i++)
                    {
                        if(routers.get(i).getSerialNo() == serial)
                        {
                            r = routers.get(i);
                            r.setReservedBefore(true);
                            break;
                        }
                    }
                    // craeting invoice object
                    Invoice invoiceRent = new Invoice(res, r, person);
                    // adding this object to its arraylist
                    invoices.add(invoiceRent);
                    // calculating and displaying fees
                    invoiceRent.calculatefees();
                    System.out.println("Your fees: "+ invoiceRent.getFees());
                    System.out.println("Reserved Completed");
                    System.out.println("Press[0] to go to main menu"); 




                }else if (choice == 1) // display all invoices 
                {
                    if (invoices.size() == 0)
                        System.out.println("No invoices yet");
                    // looping the invoices arraylist
                    for (int i = 0; i < invoices.size(); i++)
                    {
                        System.out.println("invoice #"+i);
                        System.out.println("\tCustomer name:" + invoices.get(i).getPerson().getName());
                        System.out.println("\tReservation Date:" + invoices.get(i).getReserve().getReserveDate());
                        System.out.println("\tStart Date:" + invoices.get(i).getReserve().getStartDate());
                        System.out.println("\tEnd Date:" + invoices.get(i).getReserve().getEndDate());
                        System.out.println("\tReservation type:" + invoices.get(i).getReserve().getType());
                        System.out.println("\tReservation Number:" + invoices.get(i).getReserve().getReserveNo());
                        invoices.get(i).getRouter().displayRouterData();
                        System.out.println("\tfees:" + invoices.get(i).getFees());
                    }
                                            
                    System.out.println("Press\n[0] to go to main menu\n[1] to options"); int viewOption = scanner.nextInt();
                    if(viewOption == 1)
                    {
                        // getting the number of invoive that user want to change
                        System.out.println("Please enter the number of the invoice you want to change: "); int noInvoice = scanner.nextInt();
                        // checking if this customer is the owner of this reservation or not
                        if (invoices.get(noInvoice).getPerson().getNoCustomer() != person.getNoCustomer())
                        {
                            System.out.println("You don't have the access to view options to this invoice");
                            throw new InvalidAccessException();
                        }
                        
                        System.out.println("press\n[0] to cancel reservation\n[1] to extend reservation\n[2] to change router model\n[3]give feedback");
                        int option = scanner.nextInt();
                        if (option == 0){ // cancel
                            // calculating the difference in days between the start date and the date of cancelation 
                            long diff = invoices.get(noInvoice).getReserve().getStartDate().getTime() - today.getTime();
                            int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
                            // if the difference is more than 2 days, the customer can delete this reservation
                            if (diffDays >= 2)
                            {
                            Invoice toremove = invoices.get(noInvoice);
                            invoices.remove(noInvoice);
                            toremove.finalize();
                            }else { // throw a defined exception 
                                throw new CancelRentException();
                            }
                        }else if (option == 1){ // extend
                            System.out.println("input the type you want to extend");
                            String newType = scanner.next();
                            invoices.get(noInvoice).extend(newType);
                            // getting the available routers in this new duration 
                            availRoutersAtThisDuration(invoices.get(noInvoice).getReserve());
                            // if the router of the reservation before extention not available in the whole new duration after extention 
                            // let the user choose anthor router for the whole duration from the available routers 
                            if(!invoices.get(noInvoice).getReserve().getAvailRouter()
                                    .contains(invoices.get(noInvoice).getRouter().getSerialNo()))
                            {
                                System.out.println("your router is not avaible at this new duration, please select a router that is availble for the whole duration");
                                int serial = displayandChooseRouterAvailble(invoices.get(noInvoice).getReserve());
                                Router r = null;
                                for(int i = 0; i < routers.size(); i++)
                                {
                                    if(routers.get(i).getSerialNo() == serial)
                                    {
                                        r = routers.get(i);
                                        r.setReservedBefore(true);
                                        break;
                                    }
                                }
                                // changing the router model
                                invoices.get(noInvoice).changeModel(r);
                                // calculating fees after update
                                invoices.get(noInvoice).calculatefees();
                                System.out.println("New fees is: "+ invoices.get(noInvoice).getFees());
                                
                         }
                        }else if (option == 2){ // change router model
                            // displaying all available routers in this duration 
                            System.out.println("Select the serial number of the new router");
                            int serial = displayandChooseRouterAvailble(invoices.get(noInvoice).getReserve());
                            Router r = null;
                            for(int i = 0; i < routers.size(); i++)
                            {
                                if(routers.get(i).getSerialNo() == serial)
                                {
                                    r = routers.get(i);
                                    r.setReservedBefore(true);
                                    break;
                                }
                            }
                            // change the router model
                            invoices.get(noInvoice).changeModel(r);
                        }else if (option == 3){ // give feedback
                            System.out.println("Feedback: "); String msg= scanner.next();
                            invoices.get(noInvoice).feedback(msg);  
                    }
                    }
                }else if (choice == 2) // change today date (used as day of reservation )
                {
                   System.out.println("enter today's date"); 
                   str = scanner.next();
                   try {
                       //Parsing the String
                       today = dateFormat.parse(str);
                   } catch (ParseException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                   }
                }
                else if (choice == 3) // compare 2 routers 
                {
                    for (int i = 0; i < routers.size(); i++)
                    {
                        routers.get(i).displayRouterData();
                    }
                    
                  System.out.println("enter the serial number of the 2 routers");
                  int s1 = scanner.nextInt();
                  int s2 = scanner.nextInt();
                  boolean f1= false, f2 = false;
                  Router router1= null, router2= null; 
                  for (int i = 0; i < routers.size(); i++)
                    {
                        if (s1 == routers.get(i).getSerialNo())
                        {
                            router1 = routers.get(i);
                            f1=true;
                        }
                        if (s2 == routers.get(i).getSerialNo())
                        {
                            router2 = routers.get(i);
                            f2=true;
                        }
                        if (f1 == true && f2 == true)
                        {
                            int result = router1.compareTo(router2);
                            if (result == 0)
                                System.out.println("router 1( "+ router1.getSerialNo()+" )and router 2( "+ router2.getSerialNo()+" ) has the same number of ports");
                            else if (result == 1)
                                System.out.println("router 1( "+ router1.getSerialNo()+" ) has more ports that router 2 ( "+ router2.getSerialNo()+" )");
                            else 
                                System.out.println("router 2( "+ router2.getSerialNo()+" ) has more ports that router 1 ( "+ router1.getSerialNo()+" )");                  
                            break;
                        }
                    }
                  if (! (f1 == true && f2 == true))
                        System.out.println("Invalid input");
                }else if (choice == 4) // log out
                {
                    System.out.println("you logged out");
                    person = null;
                    break;
                

                }else{//invalid input for this condition press [0] to rent\n\t[1] to display all data
                    System.out.println("Invalid input!!!");
                    
                        System.out.println("Press\n[0] to go to main menu"); 
                }

            
            }
                
        }
        }
    }
 
    /**
     * availRoutersAtThisDuration Function is used to get the available router at certain duration 
     * the function copies all routers to an new arraylist called "availRouters"
     * then decides which routers that are not available in this duration and removes them  
     * @param res reference points at the object you want to get the available routers of its duration 
     * 
     */
    public static void availRoutersAtThisDuration(Reservation res)
    {
        ArrayList<Integer> availRouters = new ArrayList<>();
        ArrayList<Integer> remove = new ArrayList<>();
        //copy all router
        for (int i = 0; i< routers.size();i++)
        {
            availRouters.add(routers.get(i).getSerialNo());
        }
        //check not avialvle routers at this duration
        for(int i = 0; i< invoices.size(); i++)
        {
           if (!(res.getEndDate().before(invoices.get(i).getReserve().getStartDate()) ||
               res.getStartDate().after(invoices.get(i).getReserve().getEndDate())))
           {    
                remove.add(invoices.get(i).getRouter().getSerialNo());
           }
        }
        // remove them
        for (int i = 0; i< remove.size(); i++)
        {
            availRouters.remove(remove.get(i));
        }
        // soeting the routers depends on their serial numbers 
        Collections.sort(availRouters); int available = 0;
        // drop duplicates 
        List<Integer> availRoutersList = availRouters.stream().distinct().collect(Collectors.toList());
        // setting the final list to the instance variable 
        res.setAvailRouter(availRoutersList);
        
    }
    /**
     * displayandChooseRouterAvailble function displays all the available routers into console and allows the user to choose one of them  
     * @param res reference points at the object to display the available routers of its duration 
     * @return the serial number of the router that the customer choose
     */
    public static int displayandChooseRouterAvailble(Reservation res)
    {
        int available = 0;
        // displaying the available routers 
        for(int i = 0; i< routers.size(); i++)
        {
            if (routers.get(i).getSerialNo() < res.getAvailRouter().get(available))
                continue;
            else if (routers.get(i).getSerialNo() == res.getAvailRouter().get(available))
            {
                routers.get(i).displayRouterData();
                available++;
            }
            else 
                available++;
            if (available>= res.getAvailRouter().size())break;
        }
        System.out.println("Input serial number to the router you want:"); int serial = new Scanner(System.in).nextInt();
        while( !res.getAvailRouter().contains(serial))
        {
            System.out.println("Input serial number to the router you want:");
            serial = new Scanner(System.in).nextInt();
        }
        return serial;
    }
    
}
/**
 * CancelRentException extends Exception, throws when the customer cancels the reservation before the start date in less than 2 days 
 * @author user
 */

 class CancelRentException extends Exception
{
    /** the message that will be displayed when the exception throws*/
    private String msg;
    /**
     * CancelRentException Constructor 
     * calls the super class constructor 
     * initialize and  display the msg into console 
     */
    public CancelRentException()
    {
        msg = "You can't cancel the rent as the start date is after less than 2 days";
        System.out.println(msg);
    }
    
}
/**
 *  InvalidAccessException extends Exception, throws when the not-owner customer tries to edit a rent
 * @author user
 */
 class InvalidAccessException extends Exception
{    /** the message that will be displayed when the exception throws*/

        private String msg;
            /**
     * InvalidAccessException Constructor 
     * calls the super class constructor 
     * initialize and  display the msg into console 
     */
        public InvalidAccessException(){
        msg = "you can't change this reservation as you are not the owner";
        System.out.println(msg);
        }
}
/**
 *  InvalidInputException extends Exception, throws when the customer enters invalid input
 * @author user
 */
 class InvalidInputException extends Exception
{    /** the message that will be displayed when the exception throws*/
        private String msg;
    /**
     * InvalidInputException Constructor 
     * calls the super class constructor 
     * initialize and display the msg into console 
     */        
        public InvalidInputException()
        {
        msg = "Invlid input!!!";
        System.out.println(msg);
        }
}