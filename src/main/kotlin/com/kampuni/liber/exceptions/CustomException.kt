package com.kampuni.liber.exceptions

import java.time.LocalDateTime

class CustomException(var errorMsg: String, val dateTime: LocalDateTime = LocalDateTime.now().plusHours(3)): RuntimeException() {
}