-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 30 Μαρ 2016 στις 19:14:45
-- Έκδοση διακομιστή: 10.1.9-MariaDB
-- Έκδοση PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `marketdb`
--
	create database marketdb;
	use marketdb;
-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `bids`
--

CREATE TABLE `bids` (
  `bid_id` int(11) NOT NULL,
  `property_id` int(15) NOT NULL,
  `user_id` int(15) NOT NULL,
  `approved` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `onsale`
--

CREATE TABLE `onsale` (
  `property_id` int(11) NOT NULL,
  `seller_id` int(4) NOT NULL,
  `name` varchar(30) NOT NULL,
  `value` varchar(10) NOT NULL,
  `date_posted` varchar(100) NOT NULL,
  `image` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `onsale`
--

INSERT INTO `onsale` (`property_id`, `seller_id`, `name`, `value`, `date_posted`, `image`) VALUES
(10, 4, ' House 1', '23500', 'Wed Mar 30 20:04:53 EEST 2016', 'C:/Users/SoRa/Documents/house1.png'),
(11, 4, ' House 2', '233500', 'Wed Mar 30 20:05:06 EEST 2016', 'C:/Users/SoRa/Documents/house2.png'),
(12, 4, ' House 3', '9999', 'Wed Mar 30 20:05:15 EEST 2016', 'C:/Users/SoRa/Documents/house3.png');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `firstname` varchar(15) NOT NULL,
  `lastname` varchar(15) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `city` varchar(30) NOT NULL,
  `number` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `users`
--

INSERT INTO `users` (`user_id`, `firstname`, `lastname`, `username`, `password`, `city`, `number`) VALUES
(4, 'admin', 'root', 'admin', 'admin', 'admin', 'admin'),
(5, 'admin', 'admin', 'root', 'root', 'root', 'root');

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `bids`
--
ALTER TABLE `bids`
  ADD PRIMARY KEY (`bid_id`),
  ADD KEY `property_id` (`property_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Ευρετήρια για πίνακα `onsale`
--
ALTER TABLE `onsale`
  ADD PRIMARY KEY (`property_id`),
  ADD KEY `seller_id` (`seller_id`);

--
-- Ευρετήρια για πίνακα `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `bids`
--
ALTER TABLE `bids`
  MODIFY `bid_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT για πίνακα `onsale`
--
ALTER TABLE `onsale`
  MODIFY `property_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT για πίνακα `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
