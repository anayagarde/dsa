package com.algo.dsa;

import java.util.Scanner;

class node {
    node link;
    int data;
    node(int d) {
        data = d;
        link = null;
    }
}

public class Graphs {
    public static void main(String args[]) {
        Graphs graphs = new Graphs();
        graphs.create_adjacency_matrix();
        graphs.create_adjacency_list();
    }
    void create_adjacency_matrix() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of vertices: ");
        int n = sc.nextInt();
        System.out.println("Enter no of edges: ");
        int e = sc.nextInt();
        int[][] adjacency_matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacency_matrix[i][j] = 0;
            }
        }

        for(int i = 0; i< e; i++) {
            System.out.println("Enter first vertex of edge: ");
            int v = sc.nextInt();
            System.out.println("Enter second vertex of edge: ");
            int u = sc.nextInt();
            adjacency_matrix[u][v] = 1;
            adjacency_matrix[v][u] = 1;
        }

        System.out.println("Adjacency Matrix Implementation");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjacency_matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    void create_adjacency_list() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of vertices: ");
        int n = sc.nextInt();
        System.out.println("Enter no of edges: ");
        int e = sc.nextInt();

        node[] head = new node[n];
        for(int i = 0; i< e; i++) {
            System.out.println("Enter first vertex of edge: ");
            int v = sc.nextInt();
            System.out.println("Enter second vertex of edge: ");
            int u = sc.nextInt();
            head = create_list(u, v, head);
            head = create_list(v, u, head);
        }
        System.out.println("Adjacency List Implementation");
        for (int i = 0; i < n; i++) {
            for(node ptr = head[i]; ptr!=null; ptr=ptr.link) {
                System.out.print(ptr.data + " ");
            }
            System.out.println("");
        }
    }

    node[] create_list(int u, int v, node[] head) {
       node ptr;
       if (head[u] == null) {
           head[u] = new node(u);
           head[u].link = new node(v);
       } else {
           for (ptr = head[u]; ptr.link != null; ptr = ptr.link);
           ptr.link = new node(v);
       }
       return head;
    }
}

