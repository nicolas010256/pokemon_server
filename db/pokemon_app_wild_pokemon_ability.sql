-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: pokemon_app
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `wild_pokemon_ability`
--

DROP TABLE IF EXISTS wild_pokemon_ability;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE wild_pokemon_ability (
  WILD_POKEMON_ID int(11) NOT NULL,
  ABILITY_ID int(11) NOT NULL,
  PRIMARY KEY (WILD_POKEMON_ID,ABILITY_ID),
  KEY FK_WILD_POKEMON_ABILITY_ABILITY (ABILITY_ID),
  CONSTRAINT FK_WILD_POKEMON_ABILITY_ABILITY FOREIGN KEY (ABILITY_ID) REFERENCES ability (ID),
  CONSTRAINT FK_WILD_POKEMON_ABILITY_POKEMON FOREIGN KEY (WILD_POKEMON_ID) REFERENCES wild_pokemon (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wild_pokemon_ability`
--

INSERT INTO wild_pokemon_ability (WILD_POKEMON_ID, ABILITY_ID) VALUES (44,1),(88,1),(89,1),(434,1),(435,1),(568,1),(569,1),(186,2),(279,2),(382,2),(193,3),(255,3),(256,3),(257,3),(291,3),(318,3),(319,3),(469,3),(543,3),(544,3),(545,3),(10050,3),(104,4),(105,4),(140,4),(141,4),(347,4),(348,4),(451,4),(452,4),(772,4),(74,5),(75,5),(76,5),(81,5),(82,5),(95,5),(185,5),(204,5),(205,5),(208,5),(213,5),(227,5),(232,5),(299,5),(304,5),(305,5),(306,5),(369,5),(377,5),(410,5),(411,5),(438,5),(462,5),(476,5),(524,5),(525,5),(526,5),(539,5),(557,5),(558,5),(564,5),(565,5),(696,5),(703,5),(712,5),(713,5),(777,5),(790,5),(10109,5),(10110,5),(10111,5),(10154,5),(46,6),(47,6),(54,6),(55,6),(60,6),(61,6),(62,6),(116,6),(117,6),(186,6),(194,6),(195,6),(230,6),(258,6),(259,6),(260,6),(592,6),(593,6),(53,7),(106,7),(132,7),(427,7),(428,7),(431,7),(509,7),(510,7),(618,7),(701,7),(747,7),(748,7),(27,8),(28,8),(50,8),(51,8),(74,8),(75,8),(76,8),(207,8),(231,8),(232,8),(246,8),(331,8),(332,8),(443,8),(444,8),(445,8),(472,8),(618,8),(694,8),(695,8),(769,8),(770,8),(10105,8),(10106,8),(25,9),(26,9),(100,9),(101,9),(125,9),(145,9),(172,9),(179,9),(180,9),(181,9),(239,9),(309,9),(310,9),(587,9),(618,9),(10080,9),(10081,9),(10082,9),(10083,9),(10084,9),(10085,9),(10094,9),(10095,9),(10096,9),(10097,9),(10098,9),(10099,9),(10148,9),(135,10),(170,10),(171,10),(312,10),(417,10),(807,10),(10020,10),(60,11),(61,11),(62,11),(131,11),(134,11),(170,11),(171,11),(186,11),(194,11),(195,11),(226,11),(331,11),(332,11),(458,11),(535,11),(536,11),(537,11),(556,11),(592,11),(593,11),(721,11),(751,11),(752,11),(10153,11),(79,12),(80,12),(108,12),(124,12),(199,12),(220,12),(221,12),(238,12),(314,12),(320,12),(321,12),(322,12),(339,12),(340,12),(349,12),(363,12),(364,12),(365,12),(463,12),(473,12),(757,12),(758,12),(761,12),(762,12),(10129,12),(54,13),(55,13),(108,13),(333,13),(334,13),(463,13),(780,13),(12,14),(48,14),(193,14),(269,14),(290,14),(595,14),(596,14),(664,14),(666,14),(96,15),(97,15),(163,15),(164,15),(167,15),(168,15),(198,15),(225,15),(353,15),(354,15),(430,15),(710,15),(711,15),(10027,15),(10028,15),(10029,15),(10030,15),(10031,15),(10032,15),(10044,15),(352,16),(143,17),(207,17),(335,17),(37,18),(38,18),(58,18),(59,18),(77,18),(78,18),(136,18),(155,18),(156,18),(157,18),(228,18),(229,18),(485,18),(607,18),(608,18),(609,18),(631,18),(10,19),(13,19),(49,19),(265,19),(269,19),(664,19),(666,19),(742,19),(743,19),(10150,19),(79,20),(80,20),(108,20),(199,20),(235,20),(270,20),(271,20),(272,20),(322,20),(325,20),(326,20),(327,20),(431,20),(432,20),(463,20),(548,20),(549,20),(677,20),(712,20),(713,20),(749,20),(750,20),(10151,20),(224,21),(345,21),(346,21),(686,21),(687,21),(23,22),(24,22),(58,22),(59,22),(128,22),(130,22),(209,22),(210,22),(211,22),(234,22),(237,22),(262,22),(284,22),(303,22),(373,22),(397,22),(398,22),(403,22),(404,22),(405,22),(507,22),(508,22),(551,22),(552,22),(553,22),(559,22),(560,22),(725,22),(726,22),(727,22),(10021,22),(10055,22),(202,23),(360,23),(574,23),(575,23),(576,23),(10038,23),(318,24),(319,24),(443,24),(444,24),(445,24),(621,24),(292,25),(92,26),(93,26),(109,26),(110,26),(200,26),(201,26),(329,26),(330,26),(337,26),(338,26),(343,26),(344,26),(355,26),(358,26),(380,26),(381,26),(429,26),(433,26),(436,26),(437,26),(455,26),(479,26),(480,26),(481,26),(482,26),(488,26),(602,26),(603,26),(604,26),(615,26),(635,26),(738,26),(10007,26),(10008,26),(10009,26),(10010,26),(10011,26),(10012,26),(10062,26),(10063,26),(10122,26),(45,27),(46,27),(47,27),(285,27),(286,27),(590,27),(591,27),(755,27),(756,27),(63,28),(64,28),(65,28),(151,28),(177,28),(178,28),(196,28),(197,28),(280,28),(281,28),(282,28),(517,28),(518,28),(605,28),(606,28),(72,29),(73,29),(374,29),(375,29),(376,29),(377,29),(378,29),(379,29),(599,29),(600,29),(601,29),(703,29),(719,29),(113,30),(120,30),(121,30),(222,30),(242,30),(251,30),(315,30),(333,30),(334,30),(406,30),(407,30),(440,30),(492,30),(708,30),(709,30),(764,30),(25,31),(26,31),(104,31),(105,31),(111,31),(112,31),(118,31),(119,31),(172,31),(309,31),(310,31),(311,31),(464,31),(522,31),(523,31),(777,31),(10065,31),(10080,31),(10081,31),(10082,31),(10083,31),(10084,31),(10085,31),(10094,31),(10095,31),(10096,31),(10097,31),(10098,31),(10099,31),(10115,31),(10148,31),(10149,31),(10154,31),(113,32),(175,32),(176,32),(206,32),(242,32),(385,32),(440,32),(468,32),(585,32),(586,32),(648,32),(10006,32),(10018,32),(54,33),(55,33),(60,33),(61,33),(62,33),(116,33),(118,33),(119,33),(129,33),(138,33),(139,33),(140,33),(141,33),(211,33),(226,33),(230,33),(270,33),(271,33),(272,33),(283,33),(347,33),(348,33),(349,33),(367,33),(368,33),(369,33),(370,33),(418,33),(419,33),(456,33),(457,33),(458,33),(535,33),(536,33),(537,33),(564,33),(565,33),(614,33),(10064,33),(1,34),(2,34),(3,34),(43,34),(44,34),(45,34),(69,34),(70,34),(71,34),(102,34),(103,34),(114,34),(182,34),(187,34),(188,34),(189,34),(191,34),(192,34),(273,34),(274,34),(275,34),(357,34),(420,34),(465,34),(470,34),(540,34),(541,34),(542,34),(546,34),(547,34),(548,34),(549,34),(556,34),(585,34),(586,34),(120,35),(121,35),(170,35),(171,35),(313,35),(505,35),(755,35),(756,35),(137,36),(233,36),(280,36),(281,36),(282,36),(10037,36),(183,37),(184,37),(298,37),(659,37),(660,37),(10052,37),(29,38),(30,38),(31,38),(32,38),(33,38),(34,38),(117,38),(211,38),(315,38),(406,38),(407,38),(543,38),(544,38),(545,38),(690,38),(691,38),(41,39),(42,39),(63,39),(64,39),(65,39),(83,39),(96,39),(97,39),(107,39),(115,39),(149,39),(169,39),(197,39),(203,39),(215,39),(243,39),(244,39),(245,39),(361,39),(362,39),(447,39),(448,39),(538,39),(539,39),(554,39),(619,39),(620,39),(624,39),(625,39),(749,39),(750,39),(765,39),(10068,39),(218,40),(219,40),(323,40),(118,41),(119,41),(226,41),(320,41),(321,41),(367,41),(418,41),(419,41),(456,41),(457,41),(458,41),(81,42),(82,42),(299,42),(462,42),(476,42),(10109,42),(10110,42),(10111,42),(100,43),(101,43),(122,43),(293,43),(294,43),(295,43),(410,43),(411,43),(439,43),(459,43),(460,43),(626,43),(782,43),(783,43),(784,43),(10146,43),(7,44),(8,44),(9,44),(72,44),(73,44),(270,44),(271,44),(272,44),(278,44),(279,44),(283,44),(755,44),(756,44),(248,45),(449,45),(450,45),(526,45),(10049,45),(142,46),(144,46),(145,46),(146,46),(150,46),(243,46),(244,46),(245,46),(249,46),(250,46),(320,46),(321,46),(356,46),(359,46),(386,46),(416,46),(442,46),(461,46),(477,46),(483,46),(484,46),(487,46),(624,46),(625,46),(646,46),(10001,46),(10002,46),(10003,46),(86,47),(87,47),(143,47),(183,47),(184,47),(220,47),(221,47),(241,47),(296,47),(297,47),(298,47),(325,47),(326,47),(363,47),(364,47),(365,47),(432,47),(446,47),(473,47),(498,47),(499,47),(10033,47),(10091,47),(10092,47),(10093,47),(84,48),(85,48),(115,48),(165,48),(166,48),(177,48),(178,48),(191,48),(192,48),(203,48),(228,48),(229,48),(273,48),(274,48),(275,48),(77,49),(78,49),(126,49),(146,49),(218,49),(219,49),(240,49),(467,49),(485,49),(607,49),(608,49),(609,49),(636,49),(637,49),(662,49),(663,49),(10,50),(13,50),(19,50),(20,50),(43,50),(48,50),(77,50),(78,50),(84,50),(85,50),(133,50),(161,50),(162,50),(190,50),(206,50),(209,50),(261,50),(265,50),(290,50),(401,50),(417,50),(427,50),(504,50),(506,50),(16,51),(17,51),(18,51),(21,51),(22,51),(83,51),(107,51),(161,51),(162,51),(163,51),(164,51),(215,51),(227,51),(278,51),(279,51),(302,51),(396,51),(431,51),(434,51),(435,51),(441,51),(451,51),(452,51),(504,51),(505,51),(580,51),(581,51),(627,51),(628,51),(677,51),(678,51),(731,51),(732,51),(733,51),(744,51),(745,51),(10025,51),(10126,51),(98,52),(99,52),(127,52),(207,52),(303,52),(328,52),(341,52),(342,52),(472,52),(739,52),(740,52),(52,53),(190,53),(216,53),(231,53),(263,53),(264,53),(417,53),(424,53),(446,53),(506,53),(659,53),(660,53),(702,53),(710,53),(711,53),(731,53),(732,53),(10027,53),(10028,53),(10029,53),(10030,53),(10031,53),(10032,53),(10107,53),(287,54),(289,54),(632,54),(19,55),(20,55),(29,55),(30,55),(32,55),(33,55),(175,55),(176,55),(222,55),(223,55),(225,55),(415,55),(468,55),(554,55),(627,55),(632,55),(633,55),(634,55),(10091,55),(10092,55),(10093,55),(35,56),(36,56),(39,56),(40,56),(173,56),(174,56),(300,56),(301,56),(350,56),(428,56),(572,56),(573,56),(700,56),(759,56),(179,57),(180,57),(181,57),(311,57),(599,57),(600,57),(601,57),(702,57),(309,58),(310,58),(312,58),(599,58),(600,58),(601,58),(351,59),(10013,59),(10014,59),(10015,59),(88,60),(89,60),(316,60),(317,60),(422,60),(423,60),(568,60),(617,60),(11,61),(14,61),(23,61),(24,61),(147,61),(148,61),(247,61),(266,61),(268,61),(336,61),(401,61),(412,61),(559,61),(560,61),(588,61),(665,61),(19,62),(20,62),(66,62),(67,62),(68,62),(136,62),(214,62),(217,62),(236,62),(246,62),(276,62),(277,62),(296,62),(297,62),(403,62),(404,62),(405,62),(532,62),(533,62),(534,62),(538,62),(147,63),(148,63),(350,63),(72,64),(73,64),(316,64),(317,64),(1,65),(2,65),(3,65),(152,65),(153,65),(154,65),(252,65),(253,65),(254,65),(387,65),(388,65),(389,65),(495,65),(496,65),(497,65),(511,65),(512,65),(650,65),(651,65),(652,65),(722,65),(723,65),(724,65),(4,66),(5,66),(6,66),(155,66),(156,66),(157,66),(255,66),(256,66),(257,66),(390,66),(391,66),(392,66),(498,66),(499,66),(500,66),(513,66),(514,66),(653,66),(654,66),(655,66),(725,66),(726,66),(727,66),(7,67),(8,67),(9,67),(158,67),(159,67),(160,67),(258,67),(259,67),(260,67),(393,67),(394,67),(395,67),(501,67),(502,67),(503,67),(515,67),(516,67),(656,67),(657,67),(658,67),(728,67),(729,67),(730,67),(15,68),(123,68),(165,68),(166,68),(167,68),(168,68),(212,68),(214,68),(267,68),(313,68),(402,68),(414,68),(540,68),(542,68),(543,68),(544,68),(545,68),(588,68),(589,68),(595,68),(596,68),(632,68),(636,68),(637,68),(736,68),(74,69),(75,69),(76,69),(95,69),(104,69),(105,69),(111,69),(112,69),(142,69),(185,69),(208,69),(304,69),(305,69),(306,69),(369,69),(371,69),(372,69),(438,69),(697,69),(10016,69),(10115,69),(10149,69),(37,70),(38,70),(324,70),(383,70),(10035,70),(50,71),(51,71),(328,71),(56,72),(57,72),(125,72),(126,72),(225,72),(236,72),(239,72),(240,72),(288,72),(466,72),(467,72),(506,72),(744,72),(10126,72),(324,73),(631,73),(307,74),(308,74),(10054,74),(90,75),(91,75),(98,75),(99,75),(131,75),(138,75),(139,75),(324,75),(341,75),(342,75),(366,75),(387,75),(388,75),(389,75),(501,75),(502,75),(503,75),(557,75),(558,75),(589,75),(616,75),(776,75),(10071,75),(384,76),(16,77),(17,77),(18,77),(84,77),(85,77),(327,77),(441,77),(466,78),(522,78),(523,78),(587,78),(29,79),(30,79),(31,79),(32,79),(33,79),(34,79),(267,79),(403,79),(404,79),(405,79),(519,79),(520,79),(521,79),(610,79),(611,79),(612,79),(667,79),(668,79),(66,80),(67,80),(68,80),(123,80),(236,80),(237,80),(447,80),(448,80),(475,80),(744,80),(745,80),(10043,80),(144,81),(220,81),(221,81),(471,81),(473,81),(478,81),(582,81),(583,81),(613,81),(614,81),(10101,81),(10102,81),(10103,81),(10104,81),(69,82),(70,82),(71,82),(143,82),(213,82),(263,82),(264,82),(316,82),(317,82),(325,82),(326,82),(446,82),(511,82),(512,82),(513,82),(514,82),(515,82),(516,82),(631,82),(10091,82),(10092,82),(10093,82),(10112,82),(10113,82),(56,83),(57,83),(128,83),(323,83),(551,83),(552,83),(553,83),(739,83),(740,83),(106,84),(252,84),(253,84),(254,84),(425,84),(426,84),(509,84),(510,84),(617,84),(684,84),(685,84),(701,84),(436,85),(437,85),(322,86),(399,86),(400,86),(527,86),(528,86),(46,87),(47,87),(124,87),(453,87),(454,87),(694,87),(695,87),(137,88),(233,88),(474,88),(649,88),(107,89),(166,89),(390,89),(391,89),(392,89),(532,89),(533,89),(534,89),(622,89),(623,89),(674,89),(675,89),(739,89),(740,89),(285,90),(286,90),(472,90),(133,91),(341,91),(342,91),(349,91),(474,91),(550,91),(690,91),(691,91),(734,91),(735,91),(10016,91),(10059,91),(10090,91),(10121,91),(90,92),(91,92),(190,92),(424,92),(572,92),(573,92),(731,92),(732,92),(733,92),(10047,92),(86,93),(87,93),(131,93),(134,93),(238,93),(278,93),(339,93),(340,93),(368,93),(370,93),(489,93),(490,93),(535,93),(536,93),(580,93),(581,93),(594,93),(616,93),(617,93),(704,93),(705,93),(706,93),(4,94),(5,94),(6,94),(191,94),(192,94),(357,94),(694,94),(695,94),(10048,94),(135,95),(210,95),(216,95),(217,95),(261,95),(262,95),(263,95),(264,95),(285,95),(300,96),(301,96),(15,97),(21,97),(22,97),(116,97),(117,97),(167,97),(168,97),(223,97),(224,97),(230,97),(451,97),(452,97),(688,97),(689,97),(35,98),(36,98),(63,98),(64,98),(65,98),(173,98),(561,98),(577,98),(578,98),(579,98),(66,99),(67,99),(68,99),(588,99),(622,99),(623,99),(679,99),(680,99),(10073,99),(10126,99),(302,100),(52,101),(53,101),(122,101),(123,101),(212,101),(235,101),(237,101),(286,101),(402,101),(407,101),(424,101),(439,101),(572,101),(573,101),(802,101),(10046,101),(10107,101),(10108,101),(114,102),(152,102),(153,102),(154,102),(187,102),(188,102),(189,102),(315,102),(406,102),(465,102),(470,102),(541,102),(548,102),(549,102),(753,102),(754,102),(761,102),(762,102),(763,102),(10128,102),(427,103),(428,103),(527,103),(528,103),(531,103),(622,103),(623,103),(759,103),(760,103),(127,104),(408,104),(409,104),(529,104),(530,104),(538,104),(539,104),(550,104),(610,104),(611,104),(612,104),(621,104),(674,104),(675,104),(701,104),(10016,104),(10041,104),(10045,104),(175,105),(176,105),(198,105),(359,105),(430,105),(468,105),(519,105),(520,105),(521,105),(100,106),(101,106),(425,106),(426,106),(434,106),(435,106),(568,106),(569,106),(133,107),(339,107),(340,107),(413,107),(453,107),(454,107),(598,107),(10004,107),(10005,107),(96,108),(97,108),(124,108),(238,108),(517,108),(518,108),(36,109),(194,109),(195,109),(399,109),(400,109),(527,109),(528,109),(771,109),(789,109),(12,110),(48,110),(49,110),(163,110),(164,110),(314,110),(414,110),(469,110),(561,110),(122,111),(439,111),(10053,111),(486,112),(115,113),(241,113),(276,113),(277,113),(294,113),(295,113),(507,113),(508,113),(674,113),(675,113),(10088,113),(345,114),(346,114),(422,114),(423,114),(456,114),(457,114),(556,114),(86,115),(87,115),(361,115),(362,115),(363,115),(364,115),(365,115),(378,115),(471,115),(582,115),(583,115),(584,115),(712,115),(713,115),(323,116),(464,116),(564,116),(565,116),(459,117),(460,117),(584,117),(698,117),(699,117),(10060,117),(10103,117),(10104,117),(216,118),(415,118),(742,118),(743,118),(10150,118),(40,119),(161,119),(162,119),(193,119),(234,119),(353,119),(354,119),(355,119),(356,119),(469,119),(477,119),(574,119),(575,119),(576,119),(708,119),(709,119),(710,119),(711,119),(714,119),(715,119),(10027,119),(10028,119),(10029,119),(10030,119),(10031,119),(10032,119),(10114,119),(106,120),(111,120),(112,120),(396,120),(397,120),(398,120),(464,120),(500,120),(550,120),(619,120),(620,120),(626,120),(493,121),(421,122),(491,123),(215,124),(273,124),(274,124),(275,124),(461,124),(688,124),(689,124),(31,125),(34,125),(98,125),(99,125),(128,125),(158,125),(159,125),(160,125),(208,125),(296,125),(297,125),(303,125),(328,125),(371,125),(408,125),(409,125),(532,125),(533,125),(534,125),(555,125),(621,125),(627,125),(628,125),(645,125),(733,125),(10017,125),(10087,125),(213,126),(327,126),(495,126),(496,126),(497,126),(686,126),(687,126),(753,126),(754,126),(10128,126),(23,127),(24,127),(52,127),(53,127),(142,127),(150,127),(217,127),(228,127),(229,127),(248,127),(284,127),(416,127),(595,127),(596,127),(610,127),(611,127),(612,127),(667,127),(668,127),(760,127),(56,128),(57,128),(83,128),(393,128),(394,128),(395,128),(432,128),(624,128),(625,128),(628,128),(641,128),(642,128),(766,128),(566,129),(567,129),(94,130),(353,130),(354,130),(478,130),(592,130),(593,130),(10115,130),(10149,130),(113,131),(182,131),(242,131),(531,131),(594,131),(682,131),(683,131),(10069,131),(35,132),(39,132),(173,132),(174,132),(440,132),(664,132),(665,132),(666,132),(95,133),(138,133),(139,133),(140,133),(141,133),(218,133),(219,133),(227,133),(524,133),(525,133),(557,133),(558,133),(569,133),(582,133),(583,133),(584,133),(629,133),(630,133),(304,134),(305,134),(306,134),(436,134),(437,134),(212,135),(374,135),(375,135),(376,135),(379,135),(149,136),(249,136),(335,137),(425,138),(426,138),(102,139),(103,139),(357,139),(708,139),(709,139),(10114,139),(202,140),(280,140),(281,140),(282,140),(307,140),(308,140),(360,140),(483,140),(484,140),(487,140),(517,140),(518,140),(605,140),(606,140),(714,140),(715,140),(765,140),(785,140),(786,140),(787,140),(788,140),(223,141),(224,141),(235,141),(361,141),(362,141),(399,141),(400,141),(90,142),(91,142),(204,142),(205,142),(372,142),(412,142),(413,142),(540,142),(541,142),(542,142),(577,142),(578,142),(579,142),(589,142),(616,142),(629,142),(630,142),(782,142),(783,142),(784,142),(10004,142),(10005,142),(10146,142),(88,143),(89,143),(453,143),(454,143),(537,143),(690,143),(691,143),(10112,143),(10113,143),(79,144),(80,144),(114,144),(199,144),(222,144),(250,144),(465,144),(531,144),(577,144),(578,144),(579,144),(590,144),(591,144),(594,144),(619,144),(620,144),(747,144),(748,144),(10019,144),(16,145),(17,145),(18,145),(441,145),(519,145),(520,145),(521,145),(580,145),(581,145),(629,145),(630,145),(661,145),(27,146),(28,146),(507,146),(508,146),(529,146),(530,146),(745,146),(49,147),(300,147),(301,147),(561,147),(779,147),(81,148),(82,148),(120,148),(121,148),(137,148),(233,148),(462,148),(474,148),(504,148),(505,148),(605,148),(606,148),(570,149),(571,149),(132,150),(41,151),(42,151),(169,151),(187,151),(188,151),(189,151),(291,151),(336,151),(442,151),(546,151),(547,151),(607,151),(608,151),(609,151),(677,151),(678,151),(686,151),(687,151),(714,151),(715,151),(10025,151),(562,152),(563,152),(127,153),(130,153),(214,153),(262,153),(373,153),(430,153),(551,153),(552,153),(553,153),(559,153),(560,153),(667,153),(668,153),(58,154),(59,154),(359,154),(448,154),(475,154),(638,154),(639,154),(640,154),(647,154),(10024,154),(129,155),(165,155),(185,155),(206,155),(209,155),(210,155),(261,155),(293,155),(366,155),(438,155),(613,155),(10107,155),(10108,155),(177,156),(178,156),(196,156),(10057,156),(10066,156),(10075,156),(183,157),(184,157),(203,157),(234,157),(241,157),(298,157),(522,157),(523,157),(585,157),(586,157),(626,157),(672,157),(673,157),(704,157),(705,157),(706,157),(780,157),(198,158),(302,158),(313,158),(314,158),(447,158),(509,158),(510,158),(546,158),(547,158),(641,158),(642,158),(678,158),(707,158),(10056,158),(50,159),(51,159),(299,159),(422,159),(423,159),(449,159),(450,159),(476,159),(524,159),(525,159),(526,159),(529,159),(530,159),(645,159),(10058,159),(10072,159),(10105,159),(10106,159),(597,160),(598,160),(777,160),(10154,160),(555,161),(10017,161),(494,162),(643,163),(10023,163),(644,164),(10022,164),(682,165),(683,165),(669,166),(670,166),(671,166),(764,166),(10061,166),(659,167),(660,167),(702,167),(352,168),(656,168),(657,168),(658,168),(676,169),(10108,169),(653,170),(654,170),(655,170),(707,170),(720,170),(10086,170),(650,171),(651,171),(652,171),(782,171),(783,171),(784,171),(10146,171),(39,172),(40,172),(174,172),(350,172),(574,172),(575,172),(576,172),(10025,172),(696,173),(697,173),(734,173),(735,173),(779,173),(10070,173),(10121,173),(698,174),(699,174),(10074,174),(684,175),(685,175),(742,175),(743,175),(761,175),(762,175),(763,175),(10150,175),(681,176),(10026,176),(661,177),(662,177),(663,177),(692,178),(693,178),(10036,178),(672,179),(673,179),(669,180),(670,180),(671,180),(765,180),(10061,180),(688,181),(689,181),(10034,181),(10042,181),(10076,181),(10152,181),(700,182),(10051,182),(10067,182),(704,183),(705,183),(706,183),(10040,184),(10089,184),(10039,185),(717,186),(716,187),(718,188),(10077,189),(10078,190),(10079,191),(749,192),(750,192),(767,193),(768,194),(769,195),(770,195),(747,196),(748,196),(774,197),(10130,197),(10131,197),(10132,197),(10133,197),(10134,197),(10135,197),(10136,197),(10137,197),(10138,197),(10139,197),(10140,197),(10141,197),(10142,197),(734,198),(735,198),(10121,198),(751,199),(752,199),(10153,199),(781,200),(780,201),(613,202),(614,202),(10101,202),(10102,202),(722,203),(723,203),(724,203),(728,204),(729,204),(730,204),(764,205),(10109,206),(10110,206),(10111,206),(10100,207),(746,208),(10127,208),(778,209),(10143,209),(10144,209),(10145,209),(10116,210),(10117,210),(10118,211),(10119,211),(10120,211),(757,212),(758,212),(10129,212),(775,213),(763,214),(771,215),(741,216),(10123,216),(10124,216),(10125,216),(737,217),(759,218),(760,218),(779,219),(801,220),(10147,220),(10105,221),(10106,221),(766,222),(10112,223),(10113,223),(793,224),(794,224),(795,224),(796,224),(797,224),(798,224),(799,224),(803,224),(804,224),(805,224),(806,224),(773,225),(785,226),(786,227),(788,228),(787,229),(791,230),(792,231),(800,232),(10155,232),(10156,232),(10157,233);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
