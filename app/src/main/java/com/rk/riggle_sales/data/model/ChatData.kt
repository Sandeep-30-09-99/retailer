package com.rk.riggle_sales.data.model

data class ChatData(
    val chat_id: String,
    val chat_type: String,
    val message: String,
    val media: String,
    val groupid: String,
    val message_type: String,
    val sender_id: String,
    val reciver_id: String,
    val isread: String,
    val thread_id: String,
    val is_sender_trash: String,
    val is_reciver_trash: String,
    val created_at: String,
    val isActive: String,
    val read_msg_time: String
)