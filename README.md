# Character Manager — TP3 (Java Visual SIH-6406)
Proyek ini adalah fondasi model class untuk aplikasi Character Manager berbasis Java 17. Berisi enum CharacterType dan class Character dengan dua constructor, validasi pada setter, serta fitur tambahan mana dan isAlive(). Class ini akan menjadi dasar GUI pada sprint berikutnya.

## Output Terminal
![alt text](Output_.png)

## Struktur Folder
```text
CharacterManager/
│
├── src/
│   ├── com/
│   │   └── unpri/
│   │       └── charactermanager/
│   │           └── model/
│   │               ├── Character.java
│   │               └── CharacterType.java
│   │
│   └── Main.java
│
├── output.png
└── README.md
```

## Identitas
Nama: Melinda Sabella Br Sebayang
NIM: 253303621264

Analisis Bagian D (Google Docs): https://drive.google.com/file/d/10qqMgpQweH1hguRy-HufImM3rK4KVOAw/view?usp=drivesdk



# TP5 — Character Manager Sprint #2
Pada sprint ini ditambahkan class CharacterManager yang mengelola koleksi Character memakai ArrayList, dengan penolakan nama duplikat lewat equals(), getAllCharacters() yang mengembalikan salinan (defensive copy), serta counter static untuk jumlah objek yang dibuat.

## Fitur baru
equals() pada Character membandingkan nama, sehingga nama duplikat ditolak
totalCharacterCreated (static) menghitung jumlah objek Character yang dibuat
CharacterManager: addCharacter(), findByName(), removeCharacter(), getTotalCharacters(), getAllCharacters()
Mini-Challenge: getAverageLevel() (mengembalikan 0 jika list kosong) dan findByType()
Fitur mandiri: getTypeSummary()

## Screenshot output (CRUD dan eksperimen reference)
![alt text](output-tp5.png)

Screenshot memperlihatkan nama duplikat ditolak, getAverageLevel() pada list kosong menghasilkan 0.0 tanpa error, serta eksperimen reference: asli == duplikatReferensi bernilai true, sedangkan menambah karakter ke salinan list tidak mengubah total di manager (manager tetap 2, salinan menjadi 3).

Fitur mandiri (Bagian C): getTypeSummary()
getTypeSummary() merangkum jumlah karakter untuk setiap tipe (WARRIOR, MAGE, ARCHER, HEALER) dalam satu String, misalnya untuk ditampilkan di GUI pada sprint berikutnya. Method ini mengembalikan String, bukan characterList atau salinannya, karena String tidak dapat diubah dari luar. Pemanggil hanya menerima hasil hitungan dan tidak pernah memegang reference ke list internal, sehingga Encapsulation terjaga dan perubahan data hanya bisa lewat addCharacter() dan removeCharacter(). Method memakai CharacterType.values(), sehingga jika kelak ditambah tipe baru seperti NECROMANCER, method ini otomatis ikut menghitungnya tanpa perlu diubah.

## Struktur Folder Proyek (Sprint 2 - AP5 / TP5)
```text
CharacterManager/
│
├── src/
│   ├── com/
│   │   └── unpri/
│   │       └── charactermanager/
│   │           └── model/
│   │               ├── Character.java
│   │               ├── CharacterManager.java
│   │               └── CharacterType.java
│   │
│   └── Main.java
│
├── output-tp5.png
├── output.png
└── README.md
```

## Analisis Bagian D TP5 (Google Docs):
 https://drive.google.com/file/d/1rvQJx1r6zLfGoKp5hv5eG4tY80WtmCHJ/view?usp=drivesdk


 # TP8 — Character Manager Sprint #3
Pada sprint ini aplikasi berpindah dari console ke GUI. Ditambahkan class MainWindow (package view, extends JFrame) yang menampilkan daftar karakter secara dinamis lewat loop, ditambah statistik "Rata-rata Level" di bawah daftar. Main.java menjalankan jendela lewat SwingUtilities.invokeLater().

## Screenshot MainWindow
Sebelum data diubah (Gandalf level 7, rata-rata level 4.20):

![alt text](tp8-sebelum.png)

Sesudah data diubah (Gandalf level 10, rata-rata level 4.80):

![alt text](tp8=sesudah.png)

Kedua screenshot memuat 5 karakter dan membuktikan bahwa statistik ikut berubah saat data diubah.

## Aliran data: Main → CharacterManager → MainWindow
Main.java membuat CharacterManager dan mengisinya dengan lima karakter (Model). Data diambil lewat manager.getAllCharacters(), yang mengembalikan salinan list, lalu diteruskan ke constructor MainWindow. MainWindow (View) hanya menerima list itu, membuat satu JLabel untuk setiap karakter lewat loop, dan menampilkan rata-rata level, tanpa mengetahui cara data disimpan. Dalam MVC, Main untuk sementara berperan sebagai penghubung (pengganti Controller yang dibangun pada pertemuan berikutnya): Model tidak mengenal View, dan View tidak mengubah data Model.

## Karakter baru
Karakter	Tipe	Level	Alasan pemilihan
Elara	HEALER	2	Melengkapi empat tipe karakter (sebelumnya belum ada HEALER) dan level rendah agar datanya bervariasi
Gandalf	MAGE	7, lalu diubah menjadi 10	Level tinggi sehingga pengaruhnya pada rata-rata level terlihat jelas saat data diubah


## Struktur folder
```text
CharacterManager/
│
├── src/
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               ├── model/
│               │   ├── Character.java
│               │   ├── CharacterManager.java
│               │   └── CharacterType.java
│               │
│               ├── view/
│               │   └── MainWindow.java
│               │
│               └── Main.java
│
├── output-tp5.png
├── output.png
├── tp8-sebelum.png
├── tp8-sesudah.png
└── README.md
```


## Analisis Bagian D TP8 (Google Docs) :
https://drive.google.com/file/d/1Z3uJUBnxQcs_jQHz9VDmKY6ihC2xiDnz/view?usp=drivesdk



# TP10 — Character Manager Sprint #4
Pada sprint ini MainWindow naik dari v0.3 ke v0.4. Ditambahkan class AppTheme (package view) yang menjadi pusat warna, font, dan border, sehingga daftar karakter tampil sebagai kartu berwarna menurut role. Package model tidak berubah sama sekali.

## Screenshot sebelum (v0.3) dan sesudah (v0.4)

Sebelum (v0.3):

![alt text](tp10-sebelum-v04.png)


Sesudah (v0.4):

![alt text](tp10-sesudah-v03.png)

## Mengapa warna disimpan di AppTheme, bukan di Character
Warna adalah urusan tampilan, bukan data karakter, sehingga pemetaannya saya letakkan di AppTheme.colorFor(CharacterType) pada package view. Jika Character menyimpan java.awt.Color, class Model akan bergantung pada library GUI sehingga tidak bisa dipakai di aplikasi konsol atau unit test tanpa GUI, dan sulit dimigrasi ke JavaFX yang punya class Color sendiri. Dengan rancangan ini arah ketergantungan hanya satu arah (View mengenal Model lewat enum, Model tidak mengenal View), dan mengganti tema cukup dengan mengedit AppTheme.java. Bukti Model tidak berubah ada di bagian "Bukti git diff" di bawah.

## Mini-Challenge: highlight level tinggi
Karakter dengan level ≥ 5 tampil dengan teks emas dan tebal. Batasnya disimpan sebagai konstanta bernama HIGH_LEVEL_THRESHOLD = 5 di AppTheme, bukan angka tertulis di dalam if. Saya menaruhnya di View karena "level tinggi" di sini hanya aturan tampilan (kapan sebuah kartu disorot), bukan aturan permainan, dan Model memang tidak boleh diubah.

## Dua properti tambahan
Properti Komponen Tambahan
Properti	Penerapan	Alasan
Tooltip berisi detail HP/ATK	setToolTipText(describe(role) + " | HP .., ATK ..")	Detail statistik tersedia saat kursor diam di kartu tanpa membuat teks kartu terlalu panjang
setEnabled(false) untuk karakter level 1	Kartu Morgana tampil redup	Menandai karakter yang belum siap tanpa menyembunyikannya, sehingga pengguna tetap tahu karakternya ada
Batas level 1 juga disimpan sebagai konstanta bernama (DISABLED_LEVEL).

## Bukti git diff: package model tidak berubah
git diff HEAD~1 HEAD --stat -- src/com/unpri/charactermanager/model
Output perintah di atas kosong, artinya tidak ada perubahan di Character.java, CharacterType.java, maupun CharacterManager.java.

## Struktur folder
```text
CharacterManager/
├── src/
│   ├── com/
│   │   └── unpri/
│   │       └── charactermanager/
│   │           ├── model/
│   │           │   ├── Character.java
│   │           │   ├── CharacterManager.java
│   │           │   └── CharacterType.java
│   │           └── view/
│   │               ├── AppTheme.java
│   │               └── MainWindow.java
│   └── Main.java
├── README.md
├── output.png
├── output-tp5.png
├── tp8-sebelum.png
├── tp8-sesudah.png
├── tp10-sebelum-v03.png
└── tp10-sesudah-v04.png
```
## Analisis Bagian D TP10 (Google Docs) : 
https://drive.google.com/file/d/15pZIKHEtcbooPL1HmfDV0KP4A_FoDkTD/view?usp=drivesdk



# TP12 — Character Manager Sprint #5
Pada sprint ini MainWindow naik dari v0.4 ke v0.5 dengan tata letak BorderLayout yang tetap rapi saat jendela diubah ukurannya. Empat wilayah terisi: header dan panel statistik (NORTH), daftar karakter berscroll (CENTER), legenda role (EAST), dan bar status (SOUTH). Package model tidak berubah sama sekali.

## Wireframe
![alt text](tp12-wireframe.jpg.jpeg)

## Screenshot
![alt text](tp12-awal.png)

Jendela dilebarkan:

![alt text](tp12-lebar.png)

Jendela dikecilkan sampai scrollbar tampak:

![alt text](tp12-kecil.png)

## Tabel pengamatan resize (prediksi vs hasil)

| Aksi | Prediksi (berdasarkan aturan BorderLayout) | Hasil pengamatan |
| :--- | :--- | :--- |
| **Jendela dilebarkan** | Hanya wilayah **CENTER** yang ikut melebar. Legenda (`EAST`) tetap selebar isinya, sedangkan header dan bar status memanjang mengikuti lebar jendela. | Jendela dapat ditarik melebar ke kanan dan ke kiri, serta dapat di-maximize. Daftar kartu di tengah ikut melebar mengisi ruang tambahan, sementara legenda tetap berukuran sama dan header serta bar status memanjang. Hasilnya sesuai prediksi. |
| **Jendela ditinggikan** | Wilayah **CENTER** bertambah tinggi. Kartu tidak melar karena grid kartu berada di **NORTH** panel `holder`, dan legenda tetap menempel di atas. | Jendela dapat ditarik ke atas dan ke bawah. Area daftar bertambah tinggi, kartu tetap pada tinggi alaminya dengan ruang kosong di bawahnya, dan legenda tetap di bagian atas. Hasilnya sesuai prediksi. |
| **Tinggi dikecilkan** | Scrollbar muncul atau bertambah panjang di area daftar, sedangkan header dan bar status tetap terlihat. | Ketika tinggi dikecilkan, daftar karakter dapat digeser naik-turun dengan scrollbar sehingga seluruh karakter tetap bisa dilihat, dan header serta bar status tetap tampil. Hasilnya sesuai prediksi. |
| **Disempitkan sampai batas** | Jendela berhenti mengecil pada ukuran $560 \times 380$ karena `setMinimumSize`. | Jendela berhenti mengecil pada ukuran minimum dan tidak bisa diperkecil lagi, sehingga tampilan tidak terpotong. Hasilnya sesuai prediksi. |

Kesimpulannya, tata letak BorderLayout bekerja sesuai rancangan: hanya CENTER yang menyerap perubahan ukuran, area lain mempertahankan ukurannya, dan JScrollPane menjaga seluruh karakter tetap dapat diakses ketika ruang tidak cukup.|

## Struktur panel bersarang

MainWindow memakai BorderLayout dengan empat wilayah, dan setiap wilayah berisi panel yang tersusun bersarang. NORTH berisi panel pembungkus top yang memuat header (judul di kiri, jumlah karakter di kanan) dan panel statistik GridLayout 2x2. CENTER berisi JScrollPane yang membungkus panel holder, dan di NORTH holder ada panel cards ber- GridLayout yang menampung kartu karakter. EAST berisi legenda BoxLayout vertikal yang diturunkan dari CharacterType.values(), dan SOUTH berisi bar status dengan teks di kiri dan versi di kanan.

```text
MainWindow (JFrame, BorderLayout)
├── NORTH  : top (JPanel, BorderLayout)
│   ├── NORTH  : header (BorderLayout)  judul WEST, jumlah EAST
│   └── CENTER : stats (GridLayout 2x2) empat sel statistik
├── CENTER : JScrollPane
│   └── holder (BorderLayout)
│       └── NORTH : cards (GridLayout 0x1) -> kartu JLabel
├── EAST   : legend (BoxLayout Y_AXIS) -> strut, chip per role, glue
└── SOUTH  : status (BorderLayout)  teks WEST, versi EAST
```

## Panel tambahan: statistik GridLayout 2x2
Panel statistik (total karakter, rata-rata level, level tertinggi, jumlah karakter level tinggi) saya taruh di bawah header. Saya memilih GridLayout 2x2 karena keempat statistik setara dan sebaiknya berukuran seragam, serta tetap tersusun dua kolom saat jendela dilebarkan. Layout yang saya tolak:

FlowLayout: sel berukuran sesuai isi (tidak seragam), dan bisa pindah baris sendiri ketika jendela menyempit sehingga susunan 2x2 tidak stabil.
BoxLayout: hanya menyusun pada satu sumbu, sehingga 2x2 membutuhkan panel bersarang tambahan.
GridBagLayout: terlalu rumit untuk empat sel yang ukurannya sama.
Bar status awalnya memakai FlowLayout, lalu saya ganti ke BorderLayout agar teks status menempel kiri dan versi menempel kanan, karena FlowLayout tidak bisa menempelkan elemen ke sisi kanan.

Catatan: statistik dihitung di MainWindow dari list yang diterima. Idealnya perhitungan seperti itu berada di Model atau Controller, dan ini saya catat sebagai perbaikan untuk sprint berikutnya.

## Bukti git diff: package model tidak berubah
```text
git diff HEAD~1 HEAD --stat -- src/com/unpri/charactermanager/model
```
Output perintah di atas kosong, artinya tidak ada perubahan di Character.java, CharacterType.java, maupun CharacterManager.java.

## Struktur folder
```text
CharacterManager/
├── src/
│   ├── com/
│   │   └── unpri/
│   │       └── charactermanager/
│   │           ├── model/
│   │           │   ├── Character.java
│   │           │   ├── CharacterManager.java
│   │           │   └── CharacterType.java
│   │           └── view/
│   │               ├── AppTheme.java
│   │               └── MainWindow.java
│   └── Main.java
├── output-tp5.png
├── output.png
├── README.MD
├── tp8-sebelum.png
├── tp8-sesudah.png
├── tp10-sebelum-v03.png
├── tp10-sesudah-v04.png
├── tp12-awal.png
├── tp12-kecil.png
├── tp12-lebar.png
└── tp12-wireframe.jpg
```

## Analisis Bagian D TP12 (Google Docs) : 
https://docs.google.com/document/d/1jQ9VMbjG2IinEtHFYRKBhpACaiA-Vn2-/edit?usp=drive_link&ouid=114747620289340159408&rtpof=true&sd=true
