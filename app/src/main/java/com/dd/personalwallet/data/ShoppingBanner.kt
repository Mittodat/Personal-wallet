package com.dd.personalwallet.data

data class ShoppingBanner(
    val image: String? = null,
    val title: String? = null
) {
    companion object {
        val fatory by lazy { arrayListOf(
            ShoppingBanner(image = "https://picsum.photos/400/300", title = "Chăm sóc như người thân"),
            ShoppingBanner(image = "https://picsum.photos/id/237/400/300", title = "Cung cấp các dịch vụ tiện nghi"),
            ShoppingBanner(image = "https://picsum.photos/seed/picsum/400/300", title = "Có mặt khắp cả nước"),
            ShoppingBanner(image = "https://picsum.photos/400/300?grayscale", title = "Hỗ trợ nhanh chóng"),
        ) }
    }
}
