# Implementasi Binary Search Tree (BST) & Traversal 
<div align="center">

**Ujian Akhir Semester – Algoritma Pemrograman**  
🏛️ **Universitas Muhammadiyah Malang**  
📅 **Tahun Akademik 2026**

</div>
Repositori ini berisi proyek akhir semester untuk mata kuliah **Algoritma dan Pemrograman**. Program ini mengimplementasikan struktur data pohon pencarian biner (Binary Search Tree) menggunakan **Java** dengan antarmuka grafis (GUI) untuk memvisualisasikan algoritma penelusuran (traversal).

---
## 👥 Anggota Kelompok

<div align="center">

| Nama                               | NIM             |
|------------------------------------|-----------------|
| Gilbert Tetuko Julian Hunsam       | 202410370110006 |
| Restu Gilang Saputra               | 202410370110014 |
| Lexyandra Syahputra Dwi Habibillah | 202410370110030 |
| Nadila Aliza                       | 202410370110111 |

</div>

---

## Daftar Isi
1. [Tentang Proyek](#-tentang-proyek)
2. [Fitur Utama](#-fitur-utama)
3. [Konsep Algoritma](#-konsep-algoritma)
4. [Analisis Traversal](#-analisis-traversal)
5. [Struktur Kode](#-struktur-kode)
6. [Instalasi & Cara Menjalankan](#-instalasi--cara-menjalankan)
7. [Teknologi](#-teknologi)

---

## Tentang Proyek
Proyek ini dirancang untuk menunjukkan bagaimana data numerik dapat dikelola secara hierarkis. Dengan menggunakan struktur **BST**, proses pencarian dan pengurutan data menjadi jauh lebih efisien. Program ini dilengkapi dengan antarmuka **Java Swing** yang menggunakan latar belakang kustom (`background3.jpg`) untuk memberikan pengalaman pengguna yang lebih modern.

## Fitur Utama
* **Input Dinamis**: Pengguna dapat memasukkan angka satu per satu ke dalam pohon.
* **Visualisasi Hasil**: Menampilkan urutan angka secara instan setelah melakukan traversal.
* **Tiga Metode Penelusuran**: Mendukung *Pre-Order*, *In-Order*, dan *Post-Order*.
* **GUI Interaktif**: Antarmuka pengguna yang bersih dengan tombol kontrol yang intuitif.

---

## Fitur Unggulan
-   **Visualisasi GUI Modern**: Menggunakan Java Swing dengan kustomisasi background untuk tampilan yang lebih menarik dan tidak kaku.
-   **Manajemen Data Real-time**: Input angka dilakukan secara dinamis dan hasilnya langsung ditampilkan pada area teks yang tersedia.
-   **User-Friendly Control**: Tombol kontrol yang intuitif untuk memilih metode traversal hanya dengan satu klik.
-   **Robust Logic**: Penanganan error untuk input non-angka untuk menjaga stabilitas aplikasi.
---
## Konsep Algoritma
Binary Search Tree adalah pohon biner di mana setiap node mematuhi aturan berikut:
1.  **Sub-pohon Kiri**: Berisi nilai yang selalu **lebih kecil** dari node induk.
2.  **Sub-pohon Ranan**: Berisi nilai yang selalu **lebih besar** dari node induk.

### Kompleksitas Waktu:
* **Rata-rata (Average Case)**: $O(\log n)$ — Sangat cepat untuk pencarian data besar.
* **Terburuk (Worst Case)**: $O(n)$ — Terjadi jika data dimasukkan secara berurutan (pohon miring).

---

## Analisis Traversal
Program ini mendemonstrasikan tiga cara membaca data di dalam pohon:

1.  **In-Order (Left, Root, Right)**:
    * Cara kerja: Mengunjungi anak kiri, lalu root, lalu anak kanan.
    * *Kegunaan*: Menghasilkan urutan angka yang terurut dari terkecil ke terbesar.
2.  **Pre-Order (Root, Left, Right)**:
    * Cara kerja: Mengunjungi root terlebih dahulu, baru anak-anaknya.
    * *Kegunaan*: Digunakan untuk membuat salinan pohon.
3.  **Post-Order (Left, Right, Root)**:
    * Cara kerja: Mengunjungi semua anak terlebih dahulu sebelum root.
    * *Kegunaan*: Digunakan untuk menghapus pohon dari bawah ke atas.


---

## Struktur Kode
Berdasarkan file yang ada di repositori:
* `src/`: Berisi kode sumber Java (logika BST dan kelas GUI).
* `background3.jpg`: Aset visual untuk latar belakang aplikasi.
* `pom.xml`: Pengaturan dependensi jika Anda menggunakan Maven.
* `.idea/`: Konfigurasi proyek untuk IDE IntelliJ IDEA.
---
## Instalasi & Cara Menjalankan

### Prasyarat
* Java Development Kit (JDK) 8 atau versi lebih baru.
* IDE seperti IntelliJ IDEA, NetBeans, atau VS Code.

### Langkah-langkah
1.  **Download/Clone**:
    ```bash
    git clone [https://github.com/gilberthunsammm/AlgoritmaPemrograman_BST_Traversal_UAS.git](https://github.com/gilberthunsammm/AlgoritmaPemrograman_BST_Traversal_UAS.git)
    ```
2.  **Buka di IDE**: Buka folder proyek ini.
3.  **Jalankan**: Jalankan file `Main.java` (atau file yang berisi fungsi `main`).
---
## Spesifikasi
* **Bahasa**: Java
* **Framework UI**: Java Swing & AWT
* **Build Tool**: Maven (opsional)
* **Version Control**: Git
---

## Struktur Project
```text
AlgoritmaPemrograman_BST_Traversal_UAS/
├── .idea/
├── src/
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
---

Dibuat Untuk Memenuhi Tugas UAS Algoritma dan Pemrograman
