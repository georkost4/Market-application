-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 31 Μάη 2016 στις 17:04:47
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

--
-- Άδειασμα δεδομένων του πίνακα `bids`
--

INSERT INTO `bids` (`bid_id`, `property_id`, `user_id`, `approved`) VALUES
(35, 10, 5, -1),
(36, 18, 5, 1),
(37, 10, 6, 0),
(38, 11, 6, 1),
(39, 20, 4, -1),
(40, 18, 4, 0),
(41, 17, 4, 0),
(42, 12, 4, -1),
(43, 17, 6, -1);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `onsale`
--

CREATE TABLE `onsale` (
  `property_id` int(11) NOT NULL,
  `seller_id` int(4) NOT NULL,
  `on_sale` varchar(1) NOT NULL,
  `value` int(10) NOT NULL,
  `city` varchar(30) NOT NULL,
  `address` varchar(15) NOT NULL,
  `date_posted` varchar(100) NOT NULL,
  `image` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `onsale`
--

INSERT INTO `onsale` (`property_id`, `seller_id`, `on_sale`, `value`, `city`, `address`, `date_posted`, `image`) VALUES
(10, 4, '1', 23500, 'Philadelphia', 'MarketSt', 'Wed Mar 30 20:04:53 EEST 2016', 'http://192.168.1.2/house1.png'),
(11, 4, '0', 233500, 'New York', '52nd Street ', 'Wed Mar 30 20:05:06 EEST 2016', 'http://192.168.1.2/house2.png'),
(12, 5, '1', 9999, 'Chicago', '53nd Street', 'Wed Mar 30 20:05:15 EEST 2016', 'http://192.168.1.2/house3.png'),
(17, 5, '1', 239, 'Baltimore145', 'BPD', 'Tue Apr 05 20:29:06 EEST 2016', 'http://192.168.1.2/house5.png'),
(18, 6, '0', 295, 'Athens', 'Ypokrath 32', 'Tue Apr 05 21:52:33 EEST 2016', 'http://192.168.1.2/house4.png'),
(20, 6, '1', 19430, 'Oklahoma', 'Corner 5nt&10nt', 'Wed Apr 13 20:59:39 EEST 2016', 'http://192.168.1.2/house6.jpg');

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
(4, 'Antone', 'Prosthetus', 'admin', 'admin', 'Berline', '0123456789'),
(5, 'Searchius', 'Affecton', 'root', 'root', 'Copenhagh', '1234567810'),
(6, 'George', 'Kostogloudis', 'user', 'user', 'Seres', '2345678112');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `user_personal_information`
--

CREATE TABLE `user_personal_information` (
  `information_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `information` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `user_personal_information`
--

INSERT INTO `user_personal_information` (`information_id`, `user_id`, `information`) VALUES
(15, 5, 'I am currently a student at Ohio university and i am enrolled into electrical engineering department . I am a peacefull person and very friendly .'),
(16, 6, 'I am searching for a place for me at my family to settle in cause our house caught on fire recently , i have two kids and one dog .'),
(17, 4, 'I am 3D model artist and i would like to see as many of these houses available from a closer scope so i can have a better point of view .');

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
-- Ευρετήρια για πίνακα `user_personal_information`
--
ALTER TABLE `user_personal_information`
  ADD PRIMARY KEY (`information_id`),
  ADD UNIQUE KEY `user_id_2` (`user_id`),
  ADD KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `bids`
--
ALTER TABLE `bids`
  MODIFY `bid_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
--
-- AUTO_INCREMENT για πίνακα `onsale`
--
ALTER TABLE `onsale`
  MODIFY `property_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT για πίνακα `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT για πίνακα `user_personal_information`
--
ALTER TABLE `user_personal_information`
  MODIFY `information_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
