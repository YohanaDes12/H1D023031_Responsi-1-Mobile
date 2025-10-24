# Responsi 1 Pemrograman Mobile (H1D023031)

Aplikasi Android sederhana berbasis **Kotlin** yang dibuat untuk memenuhi tugas **Responsi 1 Pemrograman Mobile**.  
Aplikasi ini menampilkan berbagai informasi mengenai **klub sepak bola FC Köln (Team ID: 81)** yang datanya diambil secara langsung dari **Football-Data.org API**.

---

## 👤 Data Diri

- **Nama:** Yohana Des Ingrid Patricia Butarbutar  
- **NIM:** H1D023031  
- **Shift Baru:** E  
- **Shift Asal:** A  

---

## 📱 Deskripsi Aplikasi

Aplikasi ini menampilkan data klub sepak bola secara dinamis melalui API dengan antarmuka sederhana dan terstruktur.  
Seluruh tampilan dibangun menggunakan **Activity** dan **RecyclerView** sesuai standar pengembangan Android modern.

---

## ✨ Fitur Utama

### 🏠 1. Halaman Utama (HomeActivity)
- Menampilkan halaman pembuka berisi nama klub, logo, dan deskripsi singkat.
- Tersedia tiga menu navigasi utama: **"Club History"**, **"Head Coach"**, dan **"Team Squad"**.

### 🕰️ 2. Halaman Sejarah Klub (HistoryActivity)
- Memuat teks sejarah klub **FC Köln**.
- Data bersifat **statis** dan diambil dari berkas `res/values/strings.xml`.
- Tampilan dilengkapi dengan gambar banner yang merepresentasikan klub.

### 👔 3. Halaman Pelatih (CoachActivity)
- Menampilkan informasi pelatih utama secara **dinamis** dari API.
- Data yang ditampilkan meliputi: **Nama Pelatih, Tanggal Lahir, dan Kebangsaan**.
- Foto pelatih menggunakan gambar statis dari folder `drawable`.

### ⚽ 4. Halaman Daftar Pemain (MainActivity)
- Mengambil data **tim dan skuad pemain** berdasarkan ID tim (81) dari API.
- Menampilkan daftar pemain dalam **RecyclerView**.
- Warna latar setiap item disesuaikan berdasarkan posisi pemain:
  - **Kiper:** Kuning  
  - **Bek:** Biru  
  - **Gelandang:** Hijau  
  - **Penyerang:** Merah  
- Klik pada salah satu pemain akan menampilkan **BottomSheetDialog** berisi detail lengkap pemain (Nama, Posisi, Tanggal Lahir, Kebangsaan).

---

## 🔄 Alur Pengambilan Data (API → Aplikasi)

### 1️⃣ Permintaan Data
- Saat halaman terbuka, fungsi seperti `getTeamData(81)` dipanggil untuk mengambil data klub.
- Pemanggilan dilakukan melalui `ApiClient.kt` yang telah dikonfigurasi dengan `BASE_URL = "https://api.football-data.org/v4/"`.
- `ApiService.kt` mendefinisikan endpoint dan header, termasuk token autentikasi (`X-Auth-Token`).
- Proses berjalan secara **asinkron (asynchronous)** menggunakan `.enqueue()` agar aplikasi tetap responsif.

### 2️⃣ Penerimaan Data
- Setelah API mengirim respons, data JSON diterima dan secara otomatis diubah menjadi objek Kotlin menggunakan `GsonConverterFactory`.
- Data tersebut disimpan dalam model `TeamResponse.kt` untuk mempermudah akses atribut seperti `coach` dan `squad`.

### 3️⃣ Penampilan Data
- **CoachActivity** langsung menampilkan data pelatih pada komponen `TextView`.
- **MainActivity** mengirim daftar pemain (`squadList`) ke **PlayerAdapter** untuk ditampilkan dalam RecyclerView.
- Setiap elemen ditampilkan melalui layout `item_player.xml` dengan pewarnaan latar dinamis sesuai posisi.

---

## 📸 Demo Aplikasi
*(Tambahkan tangkapan layar atau GIF demo di sini jika sudah ada)*

---

## 💡 Kesimpulan

Aplikasi ini merupakan implementasi sederhana namun lengkap dari **pemanfaatan API publik di Android**.  
Dengan memadukan **Retrofit, RecyclerView, dan BottomSheetDialog**, aplikasi mampu menampilkan data klub dan pemain secara dinamis dan interaktif sesuai dengan ketentuan tugas **Responsi 1 Pemrograman Mobile**.


