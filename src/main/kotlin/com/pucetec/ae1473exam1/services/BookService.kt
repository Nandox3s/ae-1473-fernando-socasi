package com.pucetec.ae1473exam1.services

import com.pucetec.ae1473exam1.dto.BookRequest
import com.pucetec.ae1473exam1.dto.BookResponse
import com.pucetec.ae1473exam1.entities.Book
import com.pucetec.ae1473exam1.repositories.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    fun createBook(request: BookRequest): BookResponse {
        val book = Book(
            title = request.title.normalizeText(),
            author = request.author.normalizeText(),
            priceUsd = request.priceUsd
        )

        val savedBook = bookRepository.save(book)
        return savedBook.toResponse()
    }

    fun getAllBooks(): List<BookResponse> {
        return bookRepository.findAll()
            .map { it.toResponse() }
            .sortedBy { it.title }
    }

    private fun Book.toResponse(): BookResponse {
        return BookResponse(
            id = requireNotNull(id) { "Book id should not be null after persistence" },
            title = title,
            author = author,
            slug = title.lowercase().replace(" ", "-"),
            priceUsd = priceUsd,
            finalPrice = priceUsd * 1.12
        )
    }

    private fun String.normalizeText(): String {
        return trim()
            .split(Regex("\\s+"))
            .filter { it.isNotBlank() }
            .joinToString(" ") { word ->
                word.lowercase().replaceFirstChar { character -> character.uppercase() }
            }
    }
}