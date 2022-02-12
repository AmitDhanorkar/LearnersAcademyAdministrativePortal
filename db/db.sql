

CREATE TABLE `class` (
  `id` int NOT NULL AUTO_INCREMENT,
  `className` varchar(255) NOT NULL,
  `classTeacherName` varchar(255) DEFAULT NULL,
  `createdDt` datetime DEFAULT NULL,
  `roomNo` varchar(255) DEFAULT NULL,
  `sectionName` varchar(255) DEFAULT NULL,
  `totalNumberOfStudents` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `className` (`className`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `class` (`id`, `className`, `classTeacherName`, `createdDt`, `roomNo`, `sectionName`, `totalNumberOfStudents`) VALUES
(12, '10th Standard', 'Raghavendra', '2022-02-12 21:35:06', '101', 'A', 30);

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int NOT NULL,
  `bloodGroup` varchar(255) NOT NULL,
  `className` varchar(255) NOT NULL,
  `createdDt` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `emergencyContactNumber` varchar(255) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `updateDt` datetime DEFAULT NULL,
  `classId` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `students_ibfk_1` (`classId`),
  CONSTRAINT `students_ibfk_1` FOREIGN KEY (`classId`) REFERENCES `class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `student` ('id', 'address', 'age', 'bloodGroup', 'className', 'createdDt', 'email', 'emergencyContactNumber', 'gender', 'name', 'updateDt', 'classId') VALUES
(1, 'At Hyderabad', 16, 'A+', '10th Standard', '2022-02-12 21:36:15', 'sai@gmail.com', '1234567890', 'male', 'Sai Kishore', '2022-02-12 21:36:15', 12),
(2, 'At Hyderabad', 16, 'B+', '10th Standard', '2022-02-12 21:37:24', 'sandeep@gmail.com', '1478523690', 'male', 'Sandeep L', '2022-02-12 21:37:24', 12),
(3, 'At Hyderabad', 16, 'AB+', '10th Standard', '2022-02-12 21:38:15', 'david@gmail.com', '8523697410', 'male', 'David B', '2022-02-12 21:38:15', 12),
(4, 'At Hyderabad', 16, 'AB-', '10th Standard', '2022-02-12 21:39:13', 'aakash@gmail.com', '5236987410', 'male', 'Aakash C', '2022-02-12 21:39:13', 12);


CREATE TABLE `subject` (
  `id` int NOT NULL AUTO_INCREMENT,
  `createdDt` datetime DEFAULT NULL,
  `subjectDescription` varchar(255) DEFAULT NULL,
  `subjectName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `subjectName` (`subjectName`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `subject` (`id`, `createdDt`, `subjectDescription`, `subjectName`) VALUES
(7, '2022-02-12 21:44:52', 'Mathematics', 'Math'),
(8, '2022-02-12 21:45:12', 'Chemistry subject', 'Chemistry'),
(9, '2022-02-12 21:45:31', 'Biology sub', 'Biology'),
(10, '2022-02-12 21:45:48', 'Physics subject', 'Physics');


CREATE TABLE `class_subject_mapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `classId` int NOT NULL,
  `className` varchar(255) DEFAULT NULL,
  `createdDt` datetime DEFAULT NULL,
  `subjectId` int NOT NULL,
  `subjectName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `classId` (`classId`,`subjectId`),
  KEY `subjectId` (`subjectId`),
  CONSTRAINT `classes_subjects_mapping_ibfk_1` FOREIGN KEY (`classId`) REFERENCES `class` (`id`),
  CONSTRAINT `classes_subjects_mapping_ibfk_2` FOREIGN KEY (`subjectId`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


INSERT INTO `class_subject_mapping` (`id`, `classId`, `className`, `createdDt`, `subjectId`, `subjectName`) VALUES
(1, 12, '10th Standard', '2022-02-12 21:49:32', 10, 'Physics'),
(2, 12, '10th Standard', '2022-02-12 21:49:39', 7, 'Math'),
(3, 12, '10th Standard', '2022-02-12 21:49:46', 8, 'Chemistry'),
(4, 12, '10th Standard', '2022-02-12 21:50:01', 9, 'Biology');



CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `age` int NOT NULL,
  `contactNumber` varchar(255) NOT NULL,
  `createdDt` datetime DEFAULT NULL,
  `emailId` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `martialStatus` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `firstName` (`firstName`,`contactNumber`,`emailId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO `teacher` ('id', 'age', 'contactNumber', 'createdDt', 'emailId', 'firstName', 'gender', 'lastName', 'martialStatus', 'qualification') VALUES
(4, '35', '1023045687', '2022-02-12 21:46:40', 'raghav@gmail.com', 'Raghavendra', 'male', 'G', 'Married', 'BE'),
(5, '27', '7531594862', '2022-02-12 21:47:21', 'monali@gmail.com', 'Monali', 'female', 'D', 'Married', 'BE'),
(6, '30', '2631598745', '2022-02-12 21:48:15', 'amit@gmail.com', 'Amit', 'male', 'D', 'Married', 'BE'),
(7, '32', '1598475203', '2022-02-12 21:48:51', 'virat@gmail.com', 'Virat', 'male', 'K', 'Single', 'BE');

CREATE TABLE `teacher_class_subject_mapping` (
  `id` int NOT NULL AUTO_INCREMENT,
  `classId` int NOT NULL,
  `className` varchar(255) DEFAULT NULL,
  `createdDt` datetime DEFAULT NULL,
  `subjectId` int NOT NULL,
  `subjectName` varchar(255) DEFAULT NULL,
  `teacherId` int NOT NULL,
  `teacherName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `teacherId` (`teacherId`,`classId`,`subjectId`),
  KEY `teachers_classes_subjects_mapping_ibfk_1` (`classId`),
  KEY `teachers_classes_subjects_mapping_ibfk_2` (`subjectId`),
  CONSTRAINT `teachers_classes_subjects_mapping_ibfk_1` FOREIGN KEY (`classId`) REFERENCES `class` (`id`),
  CONSTRAINT `teachers_classes_subjects_mapping_ibfk_2` FOREIGN KEY (`subjectId`) REFERENCES `subject` (`id`),
  CONSTRAINT `teachers_classes_subjects_mapping_ibfk_3` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


INSERT INTO 'teacher_class_subject_mapping' ('id', 'classId', 'className', 'createdDt', 'subjectId', 'subjectName', 'teacherId', 'teacherName') VALUES
(1, 12, '10th Standard', '2022-02-12 21:50:16', 10, 'Physics', 4, 'Raghavendra'),
(2, 12, '10th Standard', '2022-02-12 21:50:26', 8, 'Chemistry', 5, 'Monali'),
(3, 12, '10th Standard', '2022-02-12 21:50:33', 7, 'Math', 6, 'Amit'),
(4, 12, '10th Standard', '2022-02-12 21:50:44', 8, 'Chemistry', 7, 'Virat');