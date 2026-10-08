#  Minpro-3-PBO-SistemManajemenTypesettingKomik

## Syafir Ahzami
## 2509116074

Sistem Manajemen Typesetting Komik berbasis CLI (Command Line Interface) yang dikembangkan menggunakan bahasa pemrograman Java. Program ini dirancang untuk mengelola alur pengerjaan proyek typesetting komik, data komik, serta data typesetter (baik status Tetap maupun Magang) dengan mengintegrasikan arsitektur Model-View-Controller (MVC), prinsip Abstraction, Polymorphism, Encapsulation, Inheritance, serta Interface.

---

##  Deskripsi Singkat Program

Program ini merupakan aplikasi manajemen data proyek typesetting komik berbasis konsol. Aplikasi ini membantu mengorganisir status pengerjaan komik (seperti *Dalam Pengerjaan*, *Revisi*, dan *Selesai*), perhitungan estimasi bonus pengerjaan per chapter untuk typesetter, serta pengelolaan tipe typesetter (*Tetap* dan *Magang*). Seluruh manipulasi data (Create, Read, Update, Delete) berjalan interaktif dengan mekanisme validasi penanganan error (*crash-proof*) untuk mencegah kegagalan aplikasi akibat kesalahan input pengguna.

---

##  Penjelasan Struktur Package (Arsitektur MVC)

<img width="590" height="553" alt="image" src="https://github.com/user-attachments/assets/92118567-513f-443e-b3fb-85294168b2c3" />


Program disusun menggunakan pola arsitektur **Model-View-Controller (MVC)** yang terpisah secara modular dalam package untuk memastikan prinsip *Separation of Concerns*:

* **`model`**: Berisi kelas-kelas entitas data utama (`Komik`, `Typesetter`, `TypesetterTetap`, `TypesetterMagang`, `ProyekTypeset`) yang mengelola enkapsulasi dan atribut data.
* **`interfaces`**: Berisi interface `IProyekService` sebagai *contract* standar layanan operasi pengelolaan data proyek.
* **`controllers`**: Berisi kelas `ProyekController` yang mengimplementasikan `IProyekService` untuk menangani logika bisnis, pengolahan data pada `ArrayList`, serta operasi CRUD.
* **`main`**: Berisi kelas `MainApp` yang berfungsi sebagai antarmuka CLI (*View*), menangani alur navigasi menu, pembacaan input pengguna, serta eksekusi pesan tanggapan error.

---

##  Penjelasan Alur Program
<img width="1343" height="597" alt="image" src="https://github.com/user-attachments/assets/2128fb73-3f7c-4119-8748-a81c29873404" />

Saat pertama kali aplikasi dijalankan, ProyekController secara otomatis memuat data sampel awal ke dalam ArrayList sehingga pengguna dapat langsung melihat contoh tampilan proyek.

Pengguna disajikan 5 pilihan menu:

1. Tambah Proyek Typeset: Pengguna memasukkan data proyek baru (ID Proyek, Detail Komik, Typesetter, Jenis Typesetter, Chapter, dan Status). Pengguna dipandu oleh hint/example input pada layar terminal.
<img width="702" height="515" alt="image" src="https://github.com/user-attachments/assets/ba3f2e1d-ec82-4513-bf1b-ecff3108cb70" />


2. Tampilkan Semua Proyek: Sistem mengiterasi seluruh list proyek dan mencetak rincian ID, Judul Komik, Peran Typesetter, Estimasi Bonus yang dihitung secara dinamis, serta Status Pengerjaan.
<img width="1290" height="257" alt="image" src="https://github.com/user-attachments/assets/abd0dde5-93c7-4680-8e43-3676bee24738" />

3. Update Proyek (Fitur Skip / Enter): Pengguna memilih nomor urut proyek yang ingin di-update. Sistem memberikan opsi menekan tombol ENTER (tanpa mengetik teks) jika pengguna tidak ingin mengubah nilai chapter atau status lama.
<img width="1278" height="358" alt="image" src="https://github.com/user-attachments/assets/51de6442-9f23-4754-bc4b-609ed9a017be" />



4. Hapus Proyek: Pengguna menghapus proyek berdasarkan nomor urut yang dipilih dari list.
<img width="1286" height="332" alt="image" src="https://github.com/user-attachments/assets/7103e5ac-1df9-41a5-b1d1-5cc225d1e29b" />



5. Keluar Program: Menghentikan perulangan aplikasi.
<img width="523" height="217" alt="image" src="https://github.com/user-attachments/assets/309edb8a-3d28-4f07-9314-e5ae23fc705f" />



6.  Mekanisme Error Handling & Validasi Input: Seluruh proses penerimaan angka/gaji dibungkus dalam blok try-catch (NumberFormatException). Apabila pengguna memasukkan huruf atau nilai negatif, program menampilkan pesan kesalahan tanpa mengalami crash dan meminta input ulang.
<img width="462" height="578" alt="image" src="https://github.com/user-attachments/assets/faf4f8db-83be-4e39-b9bb-278aac2332c5" />

---

##  Penjelasan Penerapan Encapsulation dan Inheritance

### Encapsulation (Enkapsulasi)
<img width="988" height="543" alt="image" src="https://github.com/user-attachments/assets/cf3fbba7-8a6b-48f5-a1ba-40b851494fc0" />

Seluruh variabel/atribut utama pada kelas model dideklarasikan dengan access modifier private (atau protected pada superclass).

<img width="586" height="122" alt="image" src="https://github.com/user-attachments/assets/1e31daba-ce16-403b-8d5c-582d9418f577" />

Variabel identifier yang nilainya konstan menggunakan modifier final (contoh: private final String idKomik dan private final String idProyek).

<img width="902" height="360" alt="image" src="https://github.com/user-attachments/assets/e0fc70a6-d4ba-40ad-b320-64a5b70c959f" />

Pembacaan dan pembaruan nilai atribut dari luar kelas diakses secara aman melalui method getter dan setter.


### Inheritance (Pewarisan)

#### Superclass: 

Kelas Typesetter bertindak sebagai induk kelas yang menyimpan atribut dasar seperti idTypesetter dan nama.

<img width="1530" height="785" alt="image" src="https://github.com/user-attachments/assets/6c342da1-6e56-4a3c-9008-89cc178478d1" />


#### Subclass:

*  TypesetterTetap menurunkan kelas Typesetter menggunakan kata kunci extends dan menambah atribut spesifik gajiPokok.

<img width="1061" height="668" alt="image" src="https://github.com/user-attachments/assets/7c753df4-f72f-4201-9fea-578a781c9065" />


*  TypesetterMagang menurunkan kelas Typesetter menggunakan kata kunci extends dan menambah atribut spesifik durasiMagangBulan.

<img width="1387" height="692" alt="image" src="https://github.com/user-attachments/assets/a41c71c0-fb39-4b2c-9c75-5e323ca00c69" />

---

##  Penjelasan Penerapan Polymorphism dan Abstraction

* Kelas Typesetter dideklarasikan sebagai abstract class yang tidak dapat diinstansiasi langsung secara independen.

<img width="737" height="216" alt="image" src="https://github.com/user-attachments/assets/e3ddc961-9bf5-4294-a14c-10417bd7b954" />

* Memuat dua abstract method:

public abstract String getPeran(); dan public abstract double hitungBonus(int jumlahChapter);

<img width="950" height="91" alt="image" src="https://github.com/user-attachments/assets/ec077bfe-7653-4fb0-b440-2ceadeb49f0d" />

Kedua method abstrak di atas memaksa setiap subclass (TypesetterTetap dan TypesetterMagang) untuk menyediakan implementasi kodenya masing-masing.


##  Polymorphism (Polimorfisme)
1.  Method Overriding (Dynamic Polymorphism):

* Method getPeran() dan hitungBonus() di-override pada subclass TypesetterTetap (perhitungan bonus Rp 15.000/chapter) dan TypesetterMagang (perhitungan bonus Rp 8.000/chapter).

<img width="902" height="302" alt="image" src="https://github.com/user-attachments/assets/941f37f4-0a1e-48ae-898a-05e9d3791c09" />

<img width="870" height="326" alt="image" src="https://github.com/user-attachments/assets/30f66263-aa00-4b6b-b816-8f6f61e4fb72" />


* Pada saat cetak data (menuTampil), pemanggilan p.getTypesetter().getPeran() dan hitungBonus() mengeksekusi logika yang berbeda secara dinamis tergantung pada tipe objek asli yang tersimpan di dalam memori.

2.  Method Overloading (Static Polymorphism):

* Terdapat pada kelas Typesetter melalui dua method dengan nama sama tetapi beda parameter:

public void tampilkanInfo() (tanpa parameter).

<img width="802" height="90" alt="image" src="https://github.com/user-attachments/assets/0012e737-e023-497b-8146-d55732d328bc" />


public void tampilkanInfo(String status) (dengan parameter String).

<img width="973" height="127" alt="image" src="https://github.com/user-attachments/assets/5094efa5-99af-400e-a8b6-3ea34085a13a" />


##  Penjelasan Letak Penerapan Nilai Tambah (Interface)
Nilai Tambah (Interface) diterapkan pada package interfaces melalui file IProyekService.java:

* Definisi Interface (interfaces/IProyekService.java):
Berisi deklarasi metode kontrak CRUD yang wajib disediakan oleh controller, meliputi:

<img width="798" height="168" alt="image" src="https://github.com/user-attachments/assets/963fd1d2-4624-4e4d-b51d-9725f0cc073d" />

* Implementasi (controllers/ProyekController.java):
Kelas ProyekController mengimplementasikan interface tersebut dengan sintaks:

<img width="787" height="102" alt="image" src="https://github.com/user-attachments/assets/2f2aaa88-2d86-44fd-b0af-7f648f3ec3dc" />

