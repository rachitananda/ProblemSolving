package com.problem.solving.ds.tree.advanced;

/**
 * https://www.youtube.com/watch?v=zIjfhVPRZCg
 * https://www.geeksforgeeks.org/trie-insert-and-search/
 * https://medium.com/basecs/trying-to-understand-tries-3ec6bede0014
 * Trie is an efficient information reTRIEeval data structure. Using Trie, search complexities can be brought to optimal
 * limit (key length). If we store keys in binary search tree, a well balanced BST will need time proportional to M * log N,
 * where M is maximum string length and N is number of keys in tree. Using Trie, we can search the key in O(M) time.
 *
 * Advantages of Trie Data Structure
 * Tries is a tree that stores strings. Maximum number of children of a node is equal to size of alphabet. Trie supports
 * search, insert and delete operations in O(L) time where L is length of key.
 *
 * Hashing:- In hashing, we convert key to a small value and the value is used to index data. Hashing supports search,
 * insert and delete operations in O(L) time on average.
 *
 * Self Balancing BST : The time complexity of search, insert and delete operations in a self-balancing Binary Search Tree (BST)
 * (like Red-Black Tree, AVL Tree, Splay Tree, etc) is O(L Log n) where n is total number words and L is length of word.
 * The advantage of Self balancing BSTs is that they maintain order which makes operations like minimum, maximum, closest
 * (floor or ceiling) and k-th largest faster. Please refer Advantages of BST over Hash Table for details.
 *
 * Why Trie? :-
 *
 * With Trie, we can insert and find strings in O(L) time where L represent the length of a single word. This is obviously
 * faster than BST. This is also faster than Hashing because of the ways it is implemented. We do not need to compute
 * any hash function. No collision handling is required (like we do in open addressing and separate chaining)
 * Another advantage of Trie is, we can easily print all words in alphabetical order which is not easily possible with hashing.
 * We can efficiently do prefix search (or auto-complete) with Trie.
 * ISSUES with Trie :-
 * The main disadvantage of tries is that they need a lot of memory for storing the strings. For each node we have too
 * many node pointers(equal to number of characters of the alphabet), if space is concerned, then Ternary Search Tree
 * can be preferred for dictionary implementations. In Ternary Search Tree, the time complexity of search operation is O(h) where h is the height of the tree. Ternary Search Trees also supports other operations supported by Trie like prefix search, alphabetical order printing, and nearest neighbor search.
 */
public class Trie { //TODO
    final int ALPHABET_SIZE=26;

    class TrieNode{

        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

    }




}
