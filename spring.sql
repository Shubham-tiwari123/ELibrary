--
-- Database: `spring`
--

-- --------------------------------------------------------

--
-- Table structure for table `E_BOOK`
--

CREATE TABLE `E_BOOK` (
  `CALLNO` varchar(200) NOT NULL PRIMARY KEY,
  `NAME` varchar(200) DEFAULT NULL,
  `AUTHOR` varchar(200) DEFAULT NULL,
  `PUBLISHER` varchar(200) DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  `ISSUED` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `E_BOOK`
--

INSERT INTO `E_BOOK` (`CALLNO`, `NAME`, `AUTHOR`, `PUBLISHER`, `QUANTITY`, `ISSUED`) VALUES
('12345', 'Maths', 'RS', 'NCERT', 20, 0),
('12346', 'CS', 'Raghula', 'yui', 12, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `E_ISSUEBOOK`
--

CREATE TABLE `E_ISSUEBOOK` (
  `CALLNO` varchar(200) DEFAULT NULL,
  `STUDENTID` varchar(200) DEFAULT NULL,
  `STUDENTNAME` varchar(200) DEFAULT NULL,
  `STUDENTMOBILE` bigint(15) DEFAULT NULL,
  `RETURNSTATUS` varchar(200) DEFAULT 'NO'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `E_ISSUEBOOK`
--

INSERT INTO `E_ISSUEBOOK` (`CALLNO`, `STUDENTID`, `STUDENTNAME`, `STUDENTMOBILE`, `RETURNSTATUS`) VALUES
('12345', '1234', 'Shubham', 9004318447, 'YES'),
('12345', '1234', 'Shubham', 9004318447, 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `E_LIBRARIAN`
--

CREATE TABLE `E_LIBRARIAN` (
  `EMAIL` varchar(200) NOT NULL PRIMARY KEY,
  `PASS` varchar(200) DEFAULT NULL,
  `NAME` varchar(200) DEFAULT NULL,
  `MOBILE` bigint(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `E_LIBRARIAN`
--

INSERT INTO `E_LIBRARIAN` (`EMAIL`, `PASS`, `NAME`, `MOBILE`) VALUES
('s@gmail.com', 'qwer', 'shiva', 9004318556),
('st1@gmail.com', '1234rt', 'buy men', 9004318556),
('st@gmail.com', '1234', 'yomen', 9004318446),
('tiwari.23.shubham@gmail.com', '12345', 'Shubham', 9004318447);

-- --------------------------------------------------------


