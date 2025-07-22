import java.util.Arrays;

class DSA {

    //Binary Search Function
    public static int binarySearch(int arr[], int size, int key) {

        int start = 0;
        int end = size - 1;

        int mid = start + (end - start) / 2;

        while (start <= end) {

            if (arr[mid] == key) {
                return mid;
            }

            //go to right wala part
            if (key > arr[mid]) {
                start = mid + 1;
            } else { //key < arr[mid]
                end = mid - 1;
            }

            mid = start + (end - start) / 2;
        }

        return -1;
    }


    //Find Peak Function
    public static int findPeak(int arr[], int n) {

        int s = 0, e = n - 1;
        int mid = s + (e - s) / 2;

        while (s < e) {
            //cout<<" s " << s <<" e " << e << endl;
            if (arr[mid] < arr[mid + 1]) {
                s = mid + 1;
            } else {
                e = mid;
            }
            mid = s + (e - s) / 2;
        }
        return s;
    }

    public static void main(String[] args) {

        int even[] = {2, 4, 6, 8, 12, 18};
        int odd[] = {3, 8, 11, 14, 16};

        int evenIndex = binarySearch(even, 6, 6);

        System.out.println("Index of 6 is " + evenIndex);

        int oddIndex = binarySearch(odd, 5, 14);

        System.out.println("Index of 14 is " + oddIndex);


        int peakIndex = findPeak(even,6);
        System.out.println("Peak index in even array: "+ peakIndex);

        peakIndex = findPeak(odd,5);
        System.out.println("Peak index in odd array: "+ peakIndex);
    }
}
