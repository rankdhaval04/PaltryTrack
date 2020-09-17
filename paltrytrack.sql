-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 08, 2019 at 04:24 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paltrytrack`
--

-- --------------------------------------------------------

--
-- Table structure for table `additem`
--

CREATE TABLE `additem` (
  `id` int(5) NOT NULL,
  `image_path` varchar(1024) NOT NULL,
  `name` varchar(1024) NOT NULL,
  `price` varchar(30) NOT NULL,
  `discription` varchar(2048) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `keyword` varchar(20) NOT NULL,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL,
  `pincode` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `additem`
--

INSERT INTO `additem` (`id`, `image_path`, `name`, `price`, `discription`, `contact`, `keyword`, `latitude`, `longitude`, `pincode`) VALUES
(1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', 'gdg', '10/kg', '', '8050505050', 'fdhdh', 21.7117, 72.9986, ''),
(2, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '1', '10/100gm', '', '7069936106', 'dty', 21.6937, 73.0088, '7069936106'),
(3, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', 'KitKat', '5/item', 'Nesle kitkat', '7069936106', 'kitkat', 9.86, 5.96, '392001'),
(4, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', 'rice', '50/kg', 'white', '555', 'rice', 21.7117, 72.9986, '55'),
(5, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '', '20/kg', 'ryy', '56', 'fg', 55, 25, '89'),
(6, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', 'qw', '23/500gm', 'eyufdd', '7069936106', 'etgf', 85, 25, '758523'),
(7, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', 'oil', '70/Liter', 'oil', '7069936106', 'sing tel', 8.96, 9.85, '392001'),
(8, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', 'oil', '100/Liter', 'kapadia oil', '7069936106', 'tel', 21.7117, 72.9986, '392001');

-- --------------------------------------------------------

--
-- Table structure for table `ads`
--

CREATE TABLE `ads` (
  `id` int(10) NOT NULL,
  `image_path` varchar(1024) NOT NULL,
  `name` varchar(1024) NOT NULL,
  `price` varchar(1024) NOT NULL,
  `discription` varchar(1024) NOT NULL,
  `quantity` int(255) NOT NULL,
  `contact` varchar(1024) NOT NULL,
  `keyword` varchar(32) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `pincode` varchar(10) NOT NULL,
  `sell` int(11) NOT NULL,
  `image` varchar(1024) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ads`
--

INSERT INTO `ads` (`id`, `image_path`, `name`, `price`, `discription`, `quantity`, `contact`, `keyword`, `latitude`, `longitude`, `pincode`, `sell`, `image`) VALUES
(1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', 'Paxo onion chicken,fries,Heinz Beans,BISTQ Granula,maemite', '530', 'PAXO onion chicken:250 gms.        SCAMPI FRIES: 250 gms.  HEINZ BEANS: 300gms  BISTQ GRANULA: 500 gms  MERMITE YEAST EXTRACT: 500gms.', 100, '7069936106', 'Chicken onion dust,Fries,Beans,', 83.6989974975586, 18.698999404907227, '392001', 0, 'https://www.britishcornershop.co.uk/assets/img/home/feature-blocks/branded-groceries.jpg'),
(2, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', 'xc', '55', 'gfgdfdx', 8, '455445', 'fg', 2.5199999809265137, 5.440000057220459, '658936', 0, 'https://www.costco.ca/wcsstore/CostcoCABCCatalogAssetStore/homepage/espot-180717-grocery-e.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `adsorder`
--

CREATE TABLE `adsorder` (
  `id` int(10) NOT NULL,
  `pid` varchar(10) NOT NULL,
  `contact` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adsorder`
--

INSERT INTO `adsorder` (`id`, `pid`, `contact`) VALUES
(2, '1', '7069936106'),
(3, '1', '7069936106'),
(4, '1', '7069936106'),
(5, '1', '7069936106'),
(6, '1', '7069936106'),
(7, '1', '7069936106'),
(8, '1', '7069936106'),
(9, '1', '7069936106'),
(10, '1', '7069936106'),
(11, '1', '7069936106'),
(12, '1', '7069936106'),
(13, '1', '7069936106'),
(14, '1', '7069936109'),
(15, '1', ''),
(16, '2', '7069936106');

-- --------------------------------------------------------

--
-- Table structure for table `combo`
--

CREATE TABLE `combo` (
  `id` int(10) NOT NULL,
  `item_title` varchar(256) NOT NULL,
  `item_url` varchar(1024) NOT NULL,
  `item_price` decimal(32,0) NOT NULL,
  `item_description` text NOT NULL,
  `big_pic` varchar(1024) NOT NULL,
  `small_pic` varchar(1024) NOT NULL,
  `was_price` decimal(32,0) NOT NULL,
  `status` int(10) NOT NULL,
  `store_id` varchar(62) NOT NULL,
  `unit` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `combo`
--

INSERT INTO `combo` (`id`, `item_title`, `item_url`, `item_price`, `item_description`, `big_pic`, `small_pic`, `was_price`, `status`, `store_id`, `unit`) VALUES
(1, 'Paxo onion chicken,fries,Heinz Beans,BISTQ Granula,maemite\r\n', 'asdfsxcdsdsdsdsdds', '530', 'PAXO onion chicken:250 gms.        \r\nSCAMPI FRIES: 250 gms.  \r\nHEINZ BEANS: 300gms  \r\nBISTQ GRANULA: 500 gms  \r\nMERMITE YEAST EXTRACT: 500gms.', 'https://www.britishcornershop.co.uk/assets/img/home/feature-blocks/branded-groceries.jpg', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '600', 0, '7069936106', '1 combo'),
(2, 'Chocolate Decorettes', '12', '500', 'Made with real chocolate, ChocoMaker Decorettes are the perfect way to dress up a wedding cake, special cupcakes or even a bowl of ice cream.\r\n\r\nMany home chefs struggle for years to learn how to get the same elegant finish they see in professionally-made cupcakes, bonbons, and frosted desserts at the bakery. Take a big step towards turning your home kitchen into a dessert bakery by stocking your pantry with ChocoMaker Decorettes.\r\n\r\nOur Decorettes come in a variety of flavors and styles to help you create stunning treats that look like they were made by a pastry chef. Unlike many other dessert accents that are simply colored sugar, each of our Chocolate Decorettes pack rich flavor and unique texture. Our White Chocolate Crisp Pearls, Dark Chocolate Curls, Marbled Chocolate Curls and Milk Chocolate Flakes add top quality chocolate accents to cakes, cupcakes, and cookies.\r\n', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOpeHpkin7oyMssj6nfBKncQcdlxR35qygfLKRbFJJV_JGcU-z4Q', 'https://cdn11.bigcommerce.com/s-f6ihfnt50p/images/stencil/600x659/products/14168/19689/10492366__37204.1545273056.jpg?c=2', '600', 0, '7069936106', '5/items');

-- --------------------------------------------------------

--
-- Table structure for table `itemorder`
--

CREATE TABLE `itemorder` (
  `id` int(5) NOT NULL,
  `pid` varchar(5) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `vcontact` varchar(15) NOT NULL,
  `quantity` int(5) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` varchar(50) NOT NULL,
  `od` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemorder`
--

INSERT INTO `itemorder` (`id`, `pid`, `contact`, `vcontact`, `quantity`, `name`, `price`, `od`) VALUES
(19, '2', 'null', '7069936106', 2, '1', '10/100gm', NULL),
(20, '6', 'null', '7069936106', 5, 'qw', '23/500gm', NULL),
(22, '3', 'null', '7069936106', 2, 'KitKat', '5/item', NULL),
(23, '6', 'null', '7069936106', 2, 'qw', '23/500gm', NULL),
(24, '3', '7069936109', '7069936106', 5, 'KitKat', '5/item', NULL),
(27, '6', '7069936109', '7069936106', 2, 'qw', '23/500gm', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `item_cart`
--

CREATE TABLE `item_cart` (
  `id` int(10) NOT NULL,
  `item_title` varchar(1024) NOT NULL,
  `quantity` int(10) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `contact` varchar(16) NOT NULL,
  `vendor_contact` varchar(16) NOT NULL,
  `status` int(5) NOT NULL,
  `small_pic` varchar(1024) NOT NULL,
  `unit` varchar(64) NOT NULL,
  `delivery_address` text NOT NULL,
  `bill_status` int(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_cart`
--

INSERT INTO `item_cart` (`id`, `item_title`, `quantity`, `price`, `contact`, `vendor_contact`, `status`, `small_pic`, `unit`, `delivery_address`, `bill_status`) VALUES
(3, 'Paxo onion chicken,fries,Heinz Beans,BISTQ Granula,maemite\r\n', 1, '530', '7069936106', '1', 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '1 combo', 'Enter Your Address', 1),
(5, 'Candy kivi flavour', 3, '20', '7069936106', '1', 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '1 item', 'Enter Your Address', 1),
(7, 'Candy kivi flavour', 1, '20', '7069936106', '1', 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '1 item', 'Enter Your Address', 1),
(9, 'Candy kivi flavour', 1, '20', '7069936106', '1', 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '1 item', 'Enter Your Address', 1),
(10, 'Candy kivi flavour', 1, '20', '7069936106', '1', 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '1 item', 'Enter Your Address', 1),
(11, 'Paxo onion chicken,fries,Heinz Beans,BISTQ Granula,maemite\r\n', 1, '530', '7069936106', '1', 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '1 combo', 'Enter Your Address', 1),
(12, 'Paxo onion chicken,fries,Heinz Beans,BISTQ Granula,maemite\r\n', 1, '530', '7069936106', '1', 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '1 combo', 'Enter Your Address', 1),
(13, 'Paxo onion chicken,fries,Heinz Beans,BISTQ Granula,maemite\r\n', 1, '530', '7069936106', '1', 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '1 combo', 'Enter Your Address', 1),
(16, 'Paxo onion chicken,fries,Heinz Beans,BISTQ Granula,maemite\r\n', 4, '530', '7069936106', '1', 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '1 combo', 'Enter Your Address', 1),
(17, 'Paxo onion chicken,fries,Heinz Beans,BISTQ Granula,maemite\r\n', 1, '530', '7069936106', '1', 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '1 combo', 'Enter Your Address', 1),
(18, 'Paxo onion chicken,fries,Heinz Beans,BISTQ Granula,maemite\r\n', 2, '530', '7069936106', '1', 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '1 combo', '', 0),
(19, 'R.C. Jain Dhaniya Powder', 1, '120', '7069936106', '48', 1, '\r\nhttps://5.imimg.com/data5/DY/VX/MY-8168145/dhaniya-powder-500x500.jpg', '1 kg.', '', 0),
(20, 'Sev Mamara', 1, '10', '7069936106', '15', 1, 'https://3.imimg.com/data3/JH/KG/MY-3618295/sev-mamara-250x250.jpg', '100 GMS', '', 0),
(21, 'Paxo onion chicken,fries,Heinz Beans,BISTQ Granula,maemite\r\n', 3, '530', '7069936106', '1', 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '1 combo', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `ml_pred`
--

CREATE TABLE `ml_pred` (
  `id` int(16) NOT NULL,
  `name` varchar(32) NOT NULL,
  `age` int(32) NOT NULL,
  `will_buy` int(32) NOT NULL,
  `a` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ml_pred`
--

INSERT INTO `ml_pred` (`id`, `name`, `age`, `will_buy`, `a`) VALUES
(5, 'hjkm', 5, 0, 12),
(11, 'dhaval', 5, 0, 3),
(12, 'dhaval', 5, 0, 3);

-- --------------------------------------------------------

--
-- Table structure for table `pred_data`
--

CREATE TABLE `pred_data` (
  `id` int(5) NOT NULL,
  `name` varchar(128) NOT NULL,
  `contact` varchar(16) NOT NULL,
  `price` int(20) NOT NULL,
  `quantity` int(20) NOT NULL,
  `off` int(20) NOT NULL,
  `pred` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pred_data`
--

INSERT INTO `pred_data` (`id`, `name`, `contact`, `price`, `quantity`, `off`, `pred`) VALUES
(1, 'Mung Dal', '7069936106', 73, 1, 7, 0),
(3, 'Mung Dal', '7069936106', 73, 1, 7, 1),
(7, 'Mung Dal', '7069936106', 73, 1, 7, 1),
(8, 'Mung Dal', '7069936106', 200, 1, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `id` int(5) NOT NULL,
  `name` varchar(20) NOT NULL,
  `age` int(5) NOT NULL,
  `password` varchar(20) NOT NULL,
  `address` varchar(200) NOT NULL,
  `contect` varchar(15) NOT NULL,
  `area` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `pincode` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`id`, `name`, `age`, `password`, `address`, `contect`, `area`, `city`, `pincode`) VALUES
(1, 'Tejasvi', 15, '1234', 'dhdudu', '7069936106', 'heud', 'sai', '392001'),
(2, 'Dhaval', 21, '1234567890', 'tsudjdh', '7069936109', 'hdjfj', 'gdjdi', '392001');

-- --------------------------------------------------------

--
-- Table structure for table `registerv`
--

CREATE TABLE `registerv` (
  `id` int(5) NOT NULL,
  `name` varchar(48) NOT NULL,
  `area` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `address` varchar(128) NOT NULL,
  `contect` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `pincode` varchar(10) NOT NULL,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registerv`
--

INSERT INTO `registerv` (`id`, `name`, `area`, `password`, `address`, `contect`, `city`, `pincode`, `latitude`, `longitude`) VALUES
(2, 'DHAVAL', 'Bharuch', '123', 'gfgf', '7069936106', 'india', '392001', 86.95, 21.95),
(3, 'harsh', 'Bharuch', '123456789', 'bharuch', '1234567890', 'bharuch', '392001', 23.12, 53.15);

-- --------------------------------------------------------

--
-- Table structure for table `store_favorite`
--

CREATE TABLE `store_favorite` (
  `id` int(5) NOT NULL,
  `store_name` varchar(128) NOT NULL,
  `store_area` varchar(128) NOT NULL,
  `contact_cust` varchar(128) NOT NULL,
  `store_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `store_favorite`
--

INSERT INTO `store_favorite` (`id`, `store_name`, `store_area`, `contact_cust`, `store_id`) VALUES
(1, 'Sahajanand', 'Bholav', '7069936106', 1);

-- --------------------------------------------------------

--
-- Table structure for table `store_items`
--

CREATE TABLE `store_items` (
  `id` int(5) NOT NULL,
  `item_title` varchar(1024) NOT NULL,
  `item_url` varchar(1024) NOT NULL,
  `item_price` decimal(16,0) NOT NULL,
  `item_description` text NOT NULL,
  `big_pic` varchar(1024) NOT NULL,
  `small_pic` varchar(1024) NOT NULL,
  `was_price` decimal(16,0) NOT NULL,
  `status` int(16) NOT NULL,
  `store_id` varchar(10) NOT NULL,
  `unit` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `store_items`
--

INSERT INTO `store_items` (`id`, `item_title`, `item_url`, `item_price`, `item_description`, `big_pic`, `small_pic`, `was_price`, `status`, `store_id`, `unit`) VALUES
(1, 'Candy kivi flavour', 'asdfghygdfbfgjh', '20', 'Candy kivi flavour\r\nCandy kivi flavour', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfmZ4m9fWcOVQs2cy0qQfCkQ-6UfDsmuNP5ox65mxrV3THRzqWcQ', '30', 0, '1', '1 item'),
(2, 'bread', '12', '40', 'Maida, Water, Sugar, Yeast, Iodised Salt, Edible Vegetable Oil, Soya Flour, Preservation E 282, Acidity Regulator - 260, Antioxidant - 300 & Improvers - 1100 \r\n\r\nUse as daily breakfast essentional. Take a slice with butter & tea \r\n\r\nEAN Code: 8908000052390\r\nManufacturer Name and Address: ALWAYS FRESH FOODS PVT LTD C1B 153 GIDC BHATPORE SURAT\r\nBest Before 2 days from the date of delivery\r\nFor Queries/Feedback/Complaints, Contact our Customer Care Executive at: Phone: 1860 123 1000 | Address: Innovative Retail Concepts Private Limited, No.18, 2nd & 3rd Floor, 80 Feet Main Road, Koramangala 4th Block, Bangalore - 560034 | Email: customerservice@bigbasket.com ', 'https://images-platform.99static.com/h0pyWTraIWVWDLsPiBs7L7ExpNo=/191x173:806x788/500x500/top/smart/99designs-contests-attachments/85/85450/attachment_85450896', 'https://images-platform.99static.com/h0pyWTraIWVWDLsPiBs7L7ExpNo=/191x173:806x788/500x500/top/smart/99designs-contests-attachments/85/85450/attachment_85450896', '50', 0, '1', '400 GMS'),
(3, 'milk', '123', '60', 'We Meenakshi Polymer Industries are a Partnership entity have marked its impressive presence since 2016 at Hyderabad, Telangana. Since commencement, we are involved as the manufacturer of Packaging Packet and Packaging Pouch. These products are highly appreciated by our clients for their remarkable quality and durability. These products are also stringently examined on numerous quality parameters before final dispatch', 'https://5.imimg.com/data5/KU/UR/MY-10339427/just-milk-packet-500x500.jpg', 'https://5.imimg.com/data5/KU/UR/MY-10339427/just-milk-packet-500x500.jpg', '80', 0, '1', '1 Litre'),
(4, 'potato chips', '12', '30', 'Have you ever tried a chippie sandwich?\r\n\r\nA great favourite with kids and adults alike, especially if the bread is covered in delicious marmite as well.\r\n\r\nHowever you want to try them, they are delicious. And they are available in a range of flavours.\r\n\r\nReady Salted, Sour Cream & Chives, Salt & Vinegar or Chicken', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnjFbsqlhMhLjXZ6SGszRShNgUS8kNUhDcDo5RIg5DrOEhMA1U', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnjFbsqlhMhLjXZ6SGszRShNgUS8kNUhDcDo5RIg5DrOEhMA1U', '40', 0, '1', '100 GMS'),
(5, 'butter', '12', '25', 'Parker is an unabashed butter fan, describing it in the first sentence of his treatise as the everlasting delight of the gourmand, the faithful ally of the culinary arts, the constant symbol of good living, as well as a sort of reserve bank, bringing farm security and financial stability to the dairy industry.', 'https://www.landolakesfoodservice.com/Foodservice/media/lol-fs-products/00034500191036-600x600.jpg', 'https://www.landolakesfoodservice.com/Foodservice/media/lol-fs-products/00034500191036-600x600.jpg', '35', 0, '1', '100 GMS'),
(6, 'Cadbury Biscuits', '12', '35', 'Cadbury Milk Chocolate Digestive Biscuits 300g Ref 12595 [Pack 12]\r\nCadbury Milk Chocolate Digestive Biscuits (300g) Pack of 12 Biscuit Packets.\r\n \r\n\r\n    Digestive biscuits covered in Cadbury milk chocolate\r\n    300g\r\n    12 Packets\r\n\r\n \r\nPhysical\r\n\r\n    Form Factor Biscuits\r\n    Pack Quantity 12\r\n    In The Box 1 x Cadbury Milk Chocolate Digestive Biscuits (300g) Pack of 12 Biscuit Packets\r\n    Dimensions 27.6cm (W) x 21.2cm (D) x 17.7cm (H) - Weight 3.863kg\r\n\r\n', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRf41ClNW5KPlvChlrODgdWFsbXHaTbLvQdx_NK4ZUV8a-NkPf3Jw', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRf41ClNW5KPlvChlrODgdWFsbXHaTbLvQdx_NK4ZUV8a-NkPf3Jw', '50', 0, '1', '300 GMS'),
(7, 'Thumbs Up', '12', '90', ' Thums Up is a brand of cola in India. The logo is a red thumbs up. It was introduced in 1977 to offset the withdrawal of The Coca-Cola Company from India. The brand was later bought by Coca-Cola who re-launched it in order to compete against Pepsi.\r\n\r\nAs of February 2012, Thums Up was the leader in the cola segment in India, commanding approximately 42% market share and an overall 15% market share in the Indian aerated waters market', 'http://ladiesfinger.in/wp-content/uploads/2018/09/1-500x500-1500871472.jpg', 'http://ladiesfinger.in/wp-content/uploads/2018/09/1-500x500-1500871472.jpg', '100', 0, '1', '2 Litre'),
(8, 'Wheat Flour', '12', '55', 'Ground from 100% whole wheat and contains more nutritional goodness for a balanced diet, so you can feel 100% good about everything that you bake with it. ', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ30hrVUBc7tWmYwb-ind7kwY808wrWKU4tCBgaQYf7eggefmyi5g', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ30hrVUBc7tWmYwb-ind7kwY808wrWKU4tCBgaQYf7eggefmyi5g', '60', 0, '1', '2 KG'),
(9, 'basmati rice', '12', '80', 'We aim to show you accurate product information. Manufacturers, suppliers and others provide what you see here, and we have not verified it. Authentic Asian taste. No MSG added (Except that which occurs naturally in yeast extract and/or hydrolyzed vegetable proteins.). sunbirdseasonings.com. Sun-Bird Seasoning Mix, Fried Rice, 0.74 Oz', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxbCd9MzBzY1vuKy1C_4RDR-HVdr6lWpuq07td7Hc3NQ7E8g8upg', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxbCd9MzBzY1vuKy1C_4RDR-HVdr6lWpuq07td7Hc3NQ7E8g8upg', '100', 0, '1', '1 kg'),
(10, 'butter milk', '12', '10', 'Incorporated in the year 2007, at Chennai, (Tamil Nadu, India), we Sati Agency, are Sole Proprietorship Firm (Individual) and a leading retailer, wholesaler and trader of a comprehensive range such as Flavored Ice Cream, Amul Lassi, Amul Butter, Amul Milk and more. Under the leadership of our Mentor Pratik Jain (Proprietor), we have gained wonderful success in the industry.', 'https://5.imimg.com/data5/XH/EN/MY-17923575/amul-butter-milk-500x500.jpg', 'https://5.imimg.com/data5/XH/EN/MY-17923575/amul-butter-milk-500x500.jpg', '13', 0, '1', '500 ML'),
(11, 'Amul  Ice Cream', '12', '30', 'Amul Tricone Ice Cream infused with original milk ice cream, in a tub that\'s big enough for all your friends.\r\n\r\nSpecifications:\r\n\r\n    Flavor: Butterscotch', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTs_Cq8yt0uOJIahF9W2ZMh5ViRqJktXvNGNLIbN3Xk1EZOF6k-', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTs_Cq8yt0uOJIahF9W2ZMh5ViRqJktXvNGNLIbN3Xk1EZOF6k-', '37', 0, '1', '1 item'),
(12, 'Sunflower OIl', '12', '86', 'Matching up with the requirements of our clients, we are involved in offering Edible Oil Packet . ', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPG3M80zllRBi6ukJcuDq-WPMu3ij64aavXaMqpCXqyqwLDhNW', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPG3M80zllRBi6ukJcuDq-WPMu3ij64aavXaMqpCXqyqwLDhNW', '138', 0, '2', '1 litere'),
(15, 'Sev Mamara', '112', '10', 'A classic favourite that is highly irresistible. Made from quality ingredients, Sev mamra is a light, crunchy snack loved by all.', 'https://3.imimg.com/data3/JH/KG/MY-3618295/sev-mamara-250x250.jpg', 'https://3.imimg.com/data3/JH/KG/MY-3618295/sev-mamara-250x250.jpg', '13', 0, '5', '100 GMS'),
(17, 'Balaji wafers(Simply salted)', '123', '27', 'Simply Salted, the original potato wafers seasoned with salt.\r\nYou cannot go wrong with this one! When you need an instant burst of taste and flavour, turn to Simply Salted and let it do its magic on your taste buds.\r\n', 'https://img.dmart.in/images/rwd/products/I/C/h/IChipsNwafer150gBLJI139XX290216_2_B.jpg', 'https://img.dmart.in/images/rwd/products/I/C/h/IChipsNwafer150gBLJI139XX290216_2_B.jpg', '35', 0, '2', '170 gm.'),
(18, 'Balaji Wafers(Magic masala)', '123', '27', 'Magic Masala, a spicy flavour for those who enjoy the taste of potato wafers with chilli and pepper. Club it with your tea or a cold drink to make it more interesting and fun.', 'https://img.dmart.in/images/rwd/products/I/C/h/IChipsNwafer150gBLJI137XX290216_2_B.jpg', 'https://img.dmart.in/images/rwd/products/I/C/h/IChipsNwafer150gBLJI137XX290216_2_B.jpg', '35', 0, '2', '170 gm'),
(19, 'Balaji Wafers(Tomato Masti)', '123', '27', 'Tomato masti wafer,Delicious flavours with tomato sprinkles', 'http://media.myonsto.com/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/t/o/tomato-masti.jpg', 'http://media.myonsto.com/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/t/o/tomato-masti.jpg', '35', 0, '2', '170 gm.'),
(20, 'Vim Dishwash Bar', '123', '20', 'To accomplish the numerous requirements of the clients, we are engaged in providing a high quality range of Vim Dishwash Bar.\r\n', 'https://4.imimg.com/data4/YP/TI/MY-26823335/vim-bar-500g-500x500.jpg', 'https://4.imimg.com/data4/YP/TI/MY-26823335/vim-bar-500g-500x500.jpg', '25', 0, '2', '15 gm.'),
(21, 'Vim bar liquid', '123', '150', 'To accomplish the numerous requirements of the clients, we are engaged in providing a high quality range of Vim Dishwash liquid.\r\n', 'https://tiimg.tistatic.com/fp/1/002/584/vim-bar-liquid-106.jpg', 'https://tiimg.tistatic.com/fp/1/002/584/vim-bar-liquid-106.jpg', '170', 0, '2', '500 gm.'),
(22, 'Masala Maggi', '123', '11', 'Counted amongst one of the renowned business names, we are exquisitely involved in offering a diverse series of Maggi Noodles. We offer this product at pocket friendly costs.\r\nTaste bhi health bhi\r\nThe Maggi Noodles that we offer are known as a quick meal with taste. The offered noodles are made by using wheat flour, palm oil, salt, noodles, garlic and onion powder that is procured from esteemed vendors of the market.\r\n', 'https://5.imimg.com/data5/BH/PL/MY-7778582/maggi-noodles-500x500.jpg', 'https://5.imimg.com/data5/BH/PL/MY-7778582/maggi-noodles-500x500.jpg', '14', 0, '2', '70 gm.'),
(23, 'Masala Maggi', '123', '11', 'Counted amongst one of the renowned business names, we are exquisitely involved in offering a diverse series of Maggi Noodles. We offer this product at pocket friendly costs.\r\nTaste bhi health bhi\r\nThe Maggi Noodles that we offer are known as a quick meal with taste. The offered noodles are made by using wheat flour, palm oil, salt, noodles, garlic and onion powder that is procured from esteemed vendors of the market', '\r\nhttps://5.imimg.com/data5/BH/PL/MY-7778582/maggi-noodles-500x500.jpg', '\r\nhttps://5.imimg.com/data5/BH/PL/MY-7778582/maggi-noodles-500x500.jpg', '14', 0, '2', '70 gm.'),
(24, 'Atta Maggi Noodles', '123', '45', 'Whole Wheat Noodles Masala\r\nMade from wholegrain\r\n', '\r\nhttps://img.tesco.com/Groceries/pi/364/8901058855364/IDShot_540x540.jpg', '\r\nhttps://img.tesco.com/Groceries/pi/364/8901058855364/IDShot_540x540.jpg', '55', 0, '2', '75 gm.'),
(27, 'Kissan Jam Berry Blast', '123', '98', 'Kissan berry blast\'s delicious flavour with black berry pulp.\r\n\r\n\r\n', 'http://2hetk92pu77x1mneobagyd81.wpengine.netdna-cdn.com/wp-content/uploads/kissan-berry-blast.jpg', 'http://2hetk92pu77x1mneobagyd81.wpengine.netdna-cdn.com/wp-content/uploads/kissan-berry-blast.jpg', '100', 0, '3', '300 gm.'),
(31, 'Dove shampoo', '123', '170', 'Strengthening Ritual Avocado & Calendula Shampoo', '\r\n\r\nhttps://shop.coles.com.au/wcsstore/Coles-CAS/images/3/1/5/3157268.jpg', '\r\n\r\nhttps://shop.coles.com.au/wcsstore/Coles-CAS/images/3/1/5/3157268.jpg', '172', 0, '3', '640 ml.'),
(32, 'Crazy Richard’s 16 oz Natural Creamy Peanut Butter', '123', '200', 'Our peanut butter is made with the highest-quality peanuts, grown right here in the United States that taste delicious just as they are, with no added sugar, salt, fat or filler. Our all-natural peanut butter, nut butters and peanut powders are the perfect choice for families looking for real nut butter without the clutter.\r\n\r\n\r\n', '\r\nhttps://www.crazyrichards.com/wp-content/uploads/2016/11/np_creamypeanut.jpg', '\r\nhttps://www.crazyrichards.com/wp-content/uploads/2016/11/np_creamypeanut.jpg', '210', 0, '3', '500 gm.'),
(34, 'Fresh Red Banana', '123', '36', 'In order to keep pace with never ending demands of the customers, our company is instrumental in offering Fresh Red Banana.\r\n\r\n\r\n\r\n', '\r\nhttps://5.imimg.com/data5/TW/XM/MY-27568370/red-banana-500x500.jpg', '\r\nhttps://5.imimg.com/data5/TW/XM/MY-27568370/red-banana-500x500.jpg', '38', 0, '4', '1 kg.'),
(35, 'Fresh Apple', '123', '350', 'An Apple a day keeps the doctor away” ,Delicious and crunchy, apple fruit is one of the most popular and favorite fruits among the health conscious, fitness lovers who firmly believe in the concept of “health is wealth.” Health Benefits of Apple, Apple fruit contains good quantities of vitamin-C and beta-carotene.Apple fruit is a good source of B-complex vitamins such as riboflavin, thiamin, and pyridoxine (vitamin B-6). Apples also carry a small amount of minerals like potassium, phosphorus, and calcium.	\r\n', '\r\nhttps://5.imimg.com/data5/YY/EN/MY-8155364/fresh-apple-500x500.jpg', '\r\nhttps://5.imimg.com/data5/YY/EN/MY-8155364/fresh-apple-500x500.jpg', '380', 0, '4', '1 kg.'),
(36, 'Red Seedless Grapes', '123', '160', 'Seedless grapes from best farms....', '\r\n\r\n\r\nhttps://az836796.vo.msecnd.net/media/image/product/en/medium/0000000004023.jpg', '\r\nhttps://az836796.vo.msecnd.net/media/image/product/en/medium/0000000004023.jpg', '162', 0, '4', '1 kg.'),
(37, 'Clean and Clear Foaming Facewash', '123', '200', 'oamin facewash with beetle extract which gives morning enery instantly.', '\r\nhttps://image3.mouthshut.com/images/imagesp/925768348s.jpg', '\r\nhttps://image3.mouthshut.com/images/imagesp/925768348s.jpg', '152', 0, '3', '250 gm.'),
(38, 'Stainless Steel Scotch Brite', '123', '10', 'Leveraging the skills of our qualified team of professionals, we are engaged in providing Stainless Steel Scotch Brite.', '\r\nhttps://5.imimg.com/data5/ST/LM/MY-22975209/ss-scotch-bright-500x500.jpg', '\r\nhttps://5.imimg.com/data5/ST/LM/MY-22975209/ss-scotch-bright-500x500.jpg', '11', 0, '4', '1 piece'),
(39, 'tejku', '12', '80', 'dfghjkrtyui', 'https://www.crazyrichards.com/wp-content/uploads/2016/11/np_creamypeanut.jpg', 'https://www.crazyrichards.com/wp-content/uploads/2016/11/np_creamypeanut.jpg', '100', 0, '3', 'hjk'),
(40, 'Fresh Mango', '12', '60', 'Fresh Mango', 'https://5.imimg.com/data5/KI/YJ/MY-26818540/fresh-mango-500x500.jpg', 'https://5.imimg.com/data5/KI/YJ/MY-26818540/fresh-mango-500x500.jpg', '60', 0, '6', '1 kg'),
(41, 'Fresh Red Banana', '123', '36', '\r\nIn order to keep pace with never ending demands of the customers, our company is instrumental in offering Fresh Red Banana.\r\n', '\r\n\r\nhttps://5.imimg.com/data5/TW/XM/MY-27568370/red-banana-500x500.jpg', '\r\n\r\nhttps://5.imimg.com/data5/TW/XM/MY-27568370/red-banana-500x500.jpg', '39', 0, '6', '1 kg.'),
(42, 'Fresh Apple', '123', '50', 'fresh apples.An apple a day keeps doctor away.', '\r\nhttps://5.imimg.com/data5/YY/EN/MY-8155364/fresh-apple-500x500.jpg', '\r\nhttps://5.imimg.com/data5/YY/EN/MY-8155364/fresh-apple-500x500.jpg', '60', 0, '6', '1 kg.'),
(43, 'Seedless grapes', '123', '60', 'Seedless grapes from best farms', '\r\nhttps://az836796.vo.msecnd.net/media/image/product/en/medium/0000000004023.jpg', '\r\nhttps://az836796.vo.msecnd.net/media/image/product/en/medium/0000000004023.jpg', '65', 0, '6', '1 kg.'),
(44, 'Clean and Clear Foaming Facewash', '123', '200', 'Clean and Clear Foaming Facewash', '\r\nhttps://image3.mouthshut.com/images/imagesp/925768348s.jpg', '\r\nhttps://image3.mouthshut.com/images/imagesp/925768348s.jpg', '210', 0, '5', '1 bottle'),
(45, 'Scotch Brite', '123', '10', 'Stainless Steel Scotch Brite', '\r\nhttps://5.imimg.com/data5/ST/LM/MY-22975209/ss-scotch-bright-500x500.jpg', '\r\nhttps://5.imimg.com/data5/ST/LM/MY-22975209/ss-scotch-bright-500x500.jpg', '12', 0, '5', '1 piece'),
(46, 'Cotton Pad', '123', '80', 'Cotton Pad, for Clinical, 100 Pieces In A Pack', '\r\nhttps://5.imimg.com/data5/AP/LS/MY-4998208/cotton-pad-500x500.jpg', '\r\nhttps://5.imimg.com/data5/AP/LS/MY-4998208/cotton-pad-500x500.jpg', '83', 0, '5', '80 pieces per pouch'),
(47, 'White Urad Dal', '123', '43', 'we are involved in the sphere of offering to our customers a top class collection ofWhite Urad Dal.\r\n', 'https://5.imimg.com/data5/LW/LM/MY-8481118/urad-dal-500x500.jpg', 'https://5.imimg.com/data5/LW/LM/MY-8481118/urad-dal-500x500.jpg', '45', 0, '5', '1 kg.'),
(48, 'R.C. Jain Dhaniya Powder', '123', '120', 'We  are providing a wide array of Dhaniya Powder.', '\r\nhttps://5.imimg.com/data5/DY/VX/MY-8168145/dhaniya-powder-500x500.jpg', '\r\nhttps://5.imimg.com/data5/DY/VX/MY-8168145/dhaniya-powder-500x500.jpg', '123', 0, '7', '1 kg.'),
(49, 'Spicy Chilli Powder', '123', '50', 'Spicy Chilli Powder', 'https://5.imimg.com/data5/CE/XI/MY-8326162/spicy-chilli-powder-500x500.jpg', 'https://5.imimg.com/data5/CE/XI/MY-8326162/spicy-chilli-powder-500x500.jpg\r\n', '56', 0, '7', '50 gm.'),
(50, 'Epsom Salt', '123', '200', 'Epsom Salt', '\r\nhttps://d27ucmmhxk51xv.cloudfront.net/media/english/illustration/salt.jpg?version=1.1.82', '\r\nhttps://d27ucmmhxk51xv.cloudfront.net/media/english/illustration/salt.jpg?version=1.1.82', '210', 0, '7', '1 kg.'),
(51, 'Ashirvad Atta', '123', '170', 'Ashirvad Atta', '\r\nhttp://www.grocyhub.com/image/cache/catalog/indian_grocery/flours-souji/atta/aashirvaad-atta-select-5kg_1-800x800.jpg', '\r\nhttp://www.grocyhub.com/image/cache/catalog/indian_grocery/flours-souji/atta/aashirvaad-atta-select-5kg_1-800x800.jpg', '195', 0, '7', '5 kg.'),
(52, 'Fair and Lovely Powder Cream', '123', '35', 'powder cream', '\r\nhttps://image3.mouthshut.com/images/imagesp/925047643s.jpg', '\r\nhttps://image3.mouthshut.com/images/imagesp/925047643s.jpg', '37', 0, '7', '50 gm.'),
(53, 'Mixed Pickle', '123', '340', 'Mixed Pickle', '\r\n\r\nhttps://5.imimg.com/data5/AA/II/MY-2986067/5-kg-mixed-pickle-500x500.jpg', '\r\n\r\nhttps://5.imimg.com/data5/AA/II/MY-2986067/5-kg-mixed-pickle-500x500.jpg', '345', 0, '7', '5 kg.'),
(54, 'Whole Milk', '123', '65', 'Dairy Farmers Uht Whole Milk', '\r\nhttps://image.netxpress.biz/pi/b4/dcac7878fdc5cac0dd1e4ff5b4d4acbc514a56-2592778/full.jpg', '\r\nhttps://image.netxpress.biz/pi/b4/dcac7878fdc5cac0dd1e4ff5b4d4acbc514a56-2592778/full.jpg', '68', 0, '7', '1 litre');

-- --------------------------------------------------------

--
-- Table structure for table `store_item_quantity`
--

CREATE TABLE `store_item_quantity` (
  `id` int(10) NOT NULL,
  `item_id` int(10) NOT NULL,
  `quantity` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='store_item_quantity';

-- --------------------------------------------------------

--
-- Table structure for table `store_merch_accounts`
--

CREATE TABLE `store_merch_accounts` (
  `id` int(16) NOT NULL,
  `firstname` varchar(16) NOT NULL,
  `lastname` varchar(16) NOT NULL,
  `storename` varchar(64) NOT NULL,
  `address` varchar(256) NOT NULL,
  `area` varchar(64) NOT NULL,
  `city` varchar(28) NOT NULL,
  `pincode` int(10) NOT NULL,
  `mobnum` varchar(32) NOT NULL,
  `email` varchar(64) NOT NULL,
  `date_made` date NOT NULL,
  `pword` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `store_merch_accounts`
--

INSERT INTO `store_merch_accounts` (`id`, `firstname`, `lastname`, `storename`, `address`, `area`, `city`, `pincode`, `mobnum`, `email`, `date_made`, `pword`) VALUES
(1, 'Tejasvi', 'Kathiriya', 'Sahajanand', 'on old national highway no 8', 'Bholav', 'Bharuch', 392001, '7069936106', 'tapasvikathiriya@gmail.com', '2019-01-25', '1234'),
(2, 'Dhaval', 'Rank', 'Neelkanth', 'avadhut nagar, near old national highway ', 'Bholav', 'Bharuch', 392001, '7069936107', 'rankdhaval98@gmail.com', '2019-02-12', '1234'),
(5, 'Tony', 'Stark', 'Black Widow', 'Harihar complex', 'Tulasidham', 'Bharuch', 392001, '7069936105', 'tony98@gmail.com', '2018-12-27', '1234'),
(6, 'Rajvee', 'Vasaikar', 'Vasaikar grossary', 'shaktinath', 'shaktinath', 'Bharuch', 392003, '7069936101', 'rv55@gmail.com', '2019-03-04', '1234'),
(7, 'Tapasvi', 'Kathiriya', 'Lemoneye Stores', 'Panchbatti', 'panchbatti', 'Bharuch', 392002, '9825650342', 'tapasvi@gmail.com', '2019-03-07', 'camila');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `additem`
--
ALTER TABLE `additem`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ads`
--
ALTER TABLE `ads`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `adsorder`
--
ALTER TABLE `adsorder`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `combo`
--
ALTER TABLE `combo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `itemorder`
--
ALTER TABLE `itemorder`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item_cart`
--
ALTER TABLE `item_cart`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ml_pred`
--
ALTER TABLE `ml_pred`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pred_data`
--
ALTER TABLE `pred_data`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registerv`
--
ALTER TABLE `registerv`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `store_favorite`
--
ALTER TABLE `store_favorite`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `store_items`
--
ALTER TABLE `store_items`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `store_item_quantity`
--
ALTER TABLE `store_item_quantity`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `store_merch_accounts`
--
ALTER TABLE `store_merch_accounts`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `additem`
--
ALTER TABLE `additem`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `ads`
--
ALTER TABLE `ads`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `adsorder`
--
ALTER TABLE `adsorder`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `combo`
--
ALTER TABLE `combo`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `itemorder`
--
ALTER TABLE `itemorder`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `item_cart`
--
ALTER TABLE `item_cart`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `ml_pred`
--
ALTER TABLE `ml_pred`
  MODIFY `id` int(16) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `pred_data`
--
ALTER TABLE `pred_data`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `registerv`
--
ALTER TABLE `registerv`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `store_favorite`
--
ALTER TABLE `store_favorite`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `store_items`
--
ALTER TABLE `store_items`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `store_item_quantity`
--
ALTER TABLE `store_item_quantity`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `store_merch_accounts`
--
ALTER TABLE `store_merch_accounts`
  MODIFY `id` int(16) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
