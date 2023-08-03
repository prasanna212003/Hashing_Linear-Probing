import java.util.Scanner;

public class LinearProbing {
    int[] arr;
    int capacity;

    public LinearProbing(int capacity, int arr[]) {
        this.capacity = capacity;
        arr = new int[this.capacity];
    }

    public void insert(int ele, int arr[]) {
        if (arr[ele % capacity] == 0) {
            arr[ele % capacity] = ele;
        } else {
            int i = 1;
            while (true) {
                if (arr[(ele % capacity + i) % capacity] == 0) {
                    arr[(ele % capacity + i) % capacity] = ele;
                    break;
                }
                i++;
            }
        }
    }

    public void contains(int ele, int arr[]) {
        if (arr[ele % capacity] == ele) {
            System.out.println("The element is found at " + (arr[ele % capacity]));
        } else {
            int i = 1;
            while (true) {
                if (arr[(ele % capacity + i) % capacity] == ele) {
                    System.out.println("hii");
                    System.out.println("The element is found at " + (ele % capacity + i) % capacity);
                    break;
                }
                i++;
            }
        }
    }

    public void delete(int ele, int[] arr) {
        if (arr[ele % capacity] == ele)
            arr[ele % capacity] = 0;
        else {
            int i = 1;
            while (true) {
                if (arr[(ele % capacity + i) % capacity] == ele) {
                    System.out.println("The element is deleted");
                    arr[(ele % capacity + i) % capacity] = 0;
                    break;
                } else {
                    System.out.println("\nError : Element not found\n");
                }
                i++;
            }
        }

    }

    public void printTable(int arr[]) {
        System.out.print("\nHash Table = ");
        for (int i = 0; i < capacity; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public void clear(int arr[]) {
        for (int i = 0; i < capacity; i++) {
            arr[i] = 0;
        }
    }
    // arr=new int[capacity];}

    public static void main(String[] args) {
        System.out.println("PABBISETTY PRANAVI");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the capacity: ");

        int capacity = sc.nextInt();
        int q[] = new int[capacity];
        LinearProbing obj = new LinearProbing(capacity, q);
        System.out.println("...Menu Driven Program for Hashing Technique...");
        int choice = 0;
        while (choice < capacity) {
            System.out.println("Choose 1 option: ");
            System.out.println("1.Print HashTable");
            System.out.println("2.Insert");
            System.out.println("3.Clear");
            System.out.println("4.Delete");
            System.out.println("5.contains");
            System.out.println("6.Exit");
            System.out.println("Enter your choice(1-4): ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:

                    obj.printTable(q);
                    break;
                case 2:
                    System.out.println("Enter the element: ");
                    int element = sc.nextInt();
                    obj.insert(element, q);
                    break;
                case 3:
                    obj.clear(q);
                    break;
                case 4:
                    System.out.println("Enter the element: ");
                    int element1 = sc.nextInt();
                    obj.delete(element1, q);
                    break;
                case 5:
                    System.out.println("Enter the element: ");
                    int element2 = sc.nextInt();
                    obj.contains(element2, q);
                    break;
                case 6:
                    System.out.println("Exiting");
                    System.exit(1);
                default:
                    System.out.println("Please enter valid choice...!");
            }
        }
        sc.close();
    }
}
