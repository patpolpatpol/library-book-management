# Library Book Management API

## Endpoints

1. **Get All Books**
2. **Get Book By ID**
3. **Add a New Book**
4. **Update a Book**
5. **Delete a Book**

## Details

### 1. Get All Books

- **Method:** `GET`
- **URL:** `http://localhost:8080/books`
- **Description:** ดึงข้อมูลหนังสือทั้งหมดในระบบ

### 2. Get Book By ID

- **Method:** `GET`
- **URL:** `http://localhost:8080/books/{id}`
- **Description:** ดึงข้อมูลหนังสือตาม ID ที่ระบุ
- **Example:** `http://localhost:8080/books/1`

### 3. Add a New Book

- **Method:** `POST`
- **URL:** `http://localhost:8080/books`
- **Description:** เพิ่มหนังสือใหม่ลงในระบบ
- **Example Payload:**

  ```json
  {
    "title": "New Book Title",
    "author": "New Book Author",
    "isbn": "1234567890",
    "publishedDate": "2024-08-08"
  }

### 4.Update a Book

- **Method:** `PUT`
- **URL:** `http://localhost:8080/books/{id}`
- **Description:** อัปเดตข้อมูลหนังสือที่มีอยู่ในระบบ
- **Example:** `http://localhost:8080/books/1`
- **Example Payload:**

  ```json
  {
  "title": "Updated Book Title",
  "author": "Updated Book Author",
  "isbn": "1234567890",
  "publishedDate": "2024-08-08"
  }

### 5.Delete a Book

- **Method:** `DELETE`
- **URL:** `http://localhost:8080/books/{id}`
- **Description:** ลบหนังสือตาม ID ที่ระบุ
- **Example:** `http://localhost:8080/books/1`"# library-book-management" 
