-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.7.3-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for delivery
CREATE DATABASE IF NOT EXISTS `delivery` /*!40100 DEFAULT CHARACTER SET utf32 COLLATE utf32_vietnamese_ci */;
USE `delivery`;

-- Dumping structure for table delivery.shipping_order
CREATE TABLE IF NOT EXISTS `shipping_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `status_code` int(11) DEFAULT 1,
  `status_detail` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `create_at` datetime DEFAULT current_timestamp(),
  `update_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `service_fee` int(20) DEFAULT NULL,
  `insurance_fee` int(20) DEFAULT NULL,
  `pick_station_fee` int(20) DEFAULT NULL,
  `total_shipping_fee` int(20) DEFAULT NULL,
  `warehouse_ward` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `warehouse_district` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `warehouse_provice` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `warehouse_detail` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `receiver_name` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `receiver_phone` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `receiver_ward` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `receiver_district` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `receiver_province` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `receiver_detail` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `cod` int(20) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_code` (`order_code`),
  KEY `FK_shipping_order_status` (`status_code`),
  CONSTRAINT `FK_shipping_order_status` FOREIGN KEY (`status_code`) REFERENCES `status` (`status_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf32 COLLATE=utf32_vietnamese_ci;

-- Dumping data for table delivery.shipping_order: ~8 rows (approximately)
/*!40000 ALTER TABLE `shipping_order` DISABLE KEYS */;
INSERT INTO `shipping_order` (`id`, `order_code`, `status_code`, `status_detail`, `create_at`, `update_at`, `service_fee`, `insurance_fee`, `pick_station_fee`, `total_shipping_fee`, `warehouse_ward`, `warehouse_district`, `warehouse_provice`, `warehouse_detail`, `receiver_name`, `receiver_phone`, `receiver_ward`, `receiver_district`, `receiver_province`, `receiver_detail`, `cod`, `weight`) VALUES
	(1, 'OD1132', 4, '', '2022-11-27 09:52:15', '2022-11-29 23:42:08', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, 'OD1133', 2, 'khách hàng không phản hồi', '2022-11-27 09:56:33', '2022-11-27 10:02:39', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3, 'OD1134', 4, NULL, '2022-11-27 10:00:47', '2022-11-29 23:11:43', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(4, 'OD1135', 2, 'Đơn hàng đã đến kho Cầu Giấy', '2022-12-01 00:37:55', '2022-12-01 02:17:57', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(6, 'OD1136', 4, 'Khách hàng đổi địa chỉ giao hàng', '2022-12-01 00:38:23', '2022-12-01 02:18:44', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(7, 'OD1137', 1, NULL, '2022-12-01 00:38:39', '2022-12-01 00:38:57', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(8, 'OD1138', 1, NULL, '2022-12-01 00:38:52', '2022-12-01 00:38:52', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(12, '1234567', 1, NULL, '2023-01-06 10:46:16', '2023-01-06 10:46:16', 10, 10, 10, 10, 'Bách Khoa', 'Hai Bà Trưng', 'Hà Nội', 'Số 1 Đại Cồ Việt, Bách Khoa, Hai Bà Trưng, Hà Nội', 'Nguyễn Văn A', '0353754098', 'Bách Khoa', 'Hai Bà Trưng', 'Hà Nội', 'Số nhà 40, ngõ 12, Tạ Quang Bửu, Bách Khoa, Hai Bà Trưng, Hà Nội', 350000, 1000);
/*!40000 ALTER TABLE `shipping_order` ENABLE KEYS */;

-- Dumping structure for table delivery.shipping_product
CREATE TABLE IF NOT EXISTS `shipping_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shipping_order_id` int(11) DEFAULT NULL,
  `product_id` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '1 là gửi bình thường, 0 là gửi lại',
  `name` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `color` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `size` varchar(50) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_shipping_product_shipping_order` (`shipping_order_id`),
  CONSTRAINT `FK_shipping_product_shipping_order` FOREIGN KEY (`shipping_order_id`) REFERENCES `shipping_order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf32 COLLATE=utf32_vietnamese_ci;

-- Dumping data for table delivery.shipping_product: ~5 rows (approximately)
/*!40000 ALTER TABLE `shipping_product` DISABLE KEYS */;
INSERT INTO `shipping_product` (`id`, `shipping_order_id`, `product_id`, `quantity`, `status`, `name`, `color`, `size`, `price`) VALUES
	(1, 2, NULL, NULL, 1, NULL, NULL, NULL, NULL),
	(2, 2, NULL, NULL, 1, NULL, NULL, NULL, NULL),
	(9, 12, '1234567890', 2, 1, 'Product 1', 'red', 'M', 100000),
	(10, 12, '1234567891', 1, 1, 'Product 2', 'blue', 'L', 150000),
	(11, 12, '1234567892', 1, 1, 'Product 3', 'black', 'S', 100000);
/*!40000 ALTER TABLE `shipping_product` ENABLE KEYS */;

-- Dumping structure for table delivery.status
CREATE TABLE IF NOT EXISTS `status` (
  `status_code` int(11) NOT NULL AUTO_INCREMENT,
  `desc` varchar(255) COLLATE utf32_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`status_code`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf32 COLLATE=utf32_vietnamese_ci;

-- Dumping data for table delivery.status: ~7 rows (approximately)
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` (`status_code`, `desc`) VALUES
	(1, 'đang chuẩn bị hàng'),
	(2, 'đang giao hàng'),
	(3, 'đã giao hàng'),
	(4, 'hủy'),
	(5, 'đang xử lý đổi trả '),
	(6, 'đang xử lý trả hàng'),
	(7, 'đã nhận hàng trả lại');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
