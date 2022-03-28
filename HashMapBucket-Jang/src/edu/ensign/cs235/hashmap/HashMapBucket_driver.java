/*
    Name:           Daniel Oliveira
    Student ID:     0x2EB8D7
    Date:           Mon Jan 17 03:48:38 PM MST 2022
    Class:          CS235 Data Structures and Algorithms
    Instructor:     Daniel Oliveira

    Description:    HashMapBucket Driver


    I pledge that the work done here was my own and that I have learned how to write this program, such that I could
    throw it out and restart and finish it in a timely manner. I am not turning in any work that I cannot understand,
    describe, or recreate. I further acknowledge that I contributed substantially to all code handed in and vouch for
    its authenticity. (Daniel Oliveira)

    Visualization:
        https://www.cs.usfca.edu/~galles/visualization/BST.html
        https://visualgo.net/en

*/

package edu.ensign.cs235.hashmap;

public class HashMapBucket_driver
{
    public static void main(String[] args) {
        HashMapBucket hashmap_bucket = new HashMapBucket(51);
        hashmap_bucket.insert_hash(44);
        hashmap_bucket.insert_hash(17);
        hashmap_bucket.insert_hash(88);
        hashmap_bucket.insert_hash(8);
        hashmap_bucket.insert_hash(32);
        hashmap_bucket.insert_hash(65);
        hashmap_bucket.insert_hash(97);
        hashmap_bucket.insert_hash(28);
        hashmap_bucket.insert_hash(21);
        hashmap_bucket.insert_hash(29);
        hashmap_bucket.insert_hash(54);
        hashmap_bucket.insert_hash(82);
        hashmap_bucket.insert_hash(76);
        hashmap_bucket.insert_hash(80);
        hashmap_bucket.insert_hash(97);
        hashmap_bucket.insert_hash(93);
        hashmap_bucket.insert_hash(99);
        hashmap_bucket.insert_hash(100);

        ///
        System.out.println("\nHash table populated:");
        hashmap_bucket.show_hashtable();

        ///
        System.out.println("\nDelete key '97':");
        hashmap_bucket.delete_hash(97);

        ///
        System.out.println("\nHash table after deletion of key '97':");
        hashmap_bucket.show_hashtable();

        ///
        System.out.println("\nFind key '101':");
        System.out.println(hashmap_bucket.find_hash(101));
        System.out.println("\nFind key '100':");
        System.out.println(hashmap_bucket.find_hash(100));
    }
}
