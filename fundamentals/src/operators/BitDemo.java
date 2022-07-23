package operators;

class BitDemo {
    public static void main(String[] args) {
        int bitmask = 0x000F; // 0000 0000 0000 0000 0000 0000 0000 1111
        int val = 0x2222; // 0010 0010 0010 0010
        // prints "2"
        System.out.println(val & bitmask); // 0010 0010 & 0000 0000 0000 0000 0000 0000 0000 1111 = 0010 0010
    }
}
