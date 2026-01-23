# Implementasi Binary Search Tree (BST) & Traversal 

<div align="center">

**Ujian Akhir Semester – Algoritma Pemrograman**  
🏛️ **Universitas Muhammadiyah Malang**  
📅 **Tahun Akademik 2026**

</div>

Repositori ini berisi proyek akhir semester untuk mata kuliah **"Algoritma dan Pemrograman"** . Program ini mengimplementasikan struktur data pohon pencarian biner (Binary Search Tree) menggunakan **"Java"** dengan antarmuka grafis **(GUI)** untuk memvisualisasikan algoritma penelusuran (traversal).

---

##  Anggota Kelompok

<div align="center">

| Nama                               | NIM             |
|------------------------------------|-----------------|
| Gilbert Tetuko Julian Hunsam       | 202410370110006 |
| Restu Gilang Saputra               | 202410370110014 |
| Lexyandra Syahputra Dwi Habibillah | 202410370110030 |
| Nadila Aliza                       | 202410370110111 |

</div>

---

## 📌 Daftar Isi
1. [Tentang Proyek](#-tentang-proyek)
2. [Fitur Utama & Unggulan](#-fitur-utama--unggulan)
3. [Konsep Algoritma](#-konsep-algoritma)
4. [Analisis Traversal](#-analisis-traversal)
5. [Struktur Proyek](#-struktur-proyek)
6. [Instalasi & Cara Menjalankan](#-instalasi--cara-menjalankan)
7. [Spesifikasi Teknologi](#-spesifikasi-teknologi)

---

## Tentang Proyek
Proyek ini dirancang untuk menunjukkan bagaimana data numerik dapat dikelola secara hierarkis. Dengan menggunakan struktur **BST**, proses pencarian dan pengurutan data menjadi jauh lebih efisien. Program ini dilengkapi dengan antarmuka **Java Swing** yang menggunakan latar belakang kustom (`background3.jpg`) untuk memberikan pengalaman pengguna yang lebih modern.

---

## Fitur Utama & Unggulan
* **Input Dinamis**: Pengguna dapat memasukkan angka satu per satu ke dalam pohon secara real-time.
* **Visualisasi Hasil**: Menampilkan urutan angka secara instan setelah melakukan traversal pada area teks.
* **Tiga Metode Penelusuran**: Mendukung algoritma *Pre-Order*, *In-Order*, dan *Post-Order*.
* **GUI Modern & Interaktif**: Antarmuka bersih dengan latar belakang kustom dan tombol kontrol yang intuitif.
* **Robust Logic**: Dilengkapi dengan penanganan error (error handling) untuk input non-angka guna menjaga stabilitas aplikasi.

---

## Konsep Algoritma
Binary Search Tree (BST) adalah pohon biner di mana setiap node mematuhi aturan berikut:
1.  **Sub-pohon Kiri**: Berisi nilai yang selalu **lebih kecil** dari node induk.
2.  **Sub-pohon Kanan**: Berisi nilai yang selalu **lebih besar** dari node induk.

### Kompleksitas Waktu:
* **Rata-rata (Average Case)**: $O(\log n)$ — Sangat cepat untuk pencarian data besar.
* **Terburuk (Worst Case)**: $O(n)$ — Terjadi jika data dimasukkan secara berurutan (pohon miring).

---

## Analisis Traversal
Program ini mendemonstrasikan tiga cara membaca data di dalam pohon:

1.  **In-Order (Left, Root, Right)**
    * *Cara kerja*: Mengunjungi anak kiri, lalu root, lalu anak kanan.
    * *Kegunaan*: Menghasilkan urutan angka yang terurut dari terkecil ke terbesar (ascending).
2.  **Pre-Order (Root, Left, Right)**
    * *Cara kerja*: Mengunjungi root terlebih dahulu, baru kemudian anak-anaknya.
    * *Kegunaan*: Sering digunakan untuk membuat salinan (cloning) dari sebuah pohon.
3.  **Post-Order (Left, Right, Root)**
    * *Cara kerja*: Mengunjungi semua anak terlebih dahulu sebelum mengunjungi root.
    * *Kegunaan*: Sering digunakan dalam proses penghapusan struktur pohon (pemeriksaan dari bawah ke atas).



---

## Struktur Proyek
```text
AlgoritmaPemrograman_BST_Traversal_UAS/
├── .idea/                 
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── bst/
│   │   │           ├── Main.java         
│   │   │           ├── model/
│   │   │           │   ├── Node.java      
│   │   │           │   └── BST.java       
│   │   │           └── view/
│   │   │               └── AppFrame.java  
│   │   └── resources/
│   │       └── background3.jpg           
│   └── test/             
├── pom.xml                
├── .gitignore             
└── README.md
```
Dibuat Untuk Memenuhi Tugas UAS Algoritma dan Pemrograman
