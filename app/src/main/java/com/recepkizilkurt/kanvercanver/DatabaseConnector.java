package com.recepkizilkurt.kanvercanver;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by recep.kizilkurt on 2.08.2017.
 */

public class DatabaseConnector extends SQLiteOpenHelper{

    //database ismimiz
    private static final String DATABASE_NAME="kanvercanver.db";


    //database de bir değişiklik olması durumunda buradan versiyon değiştireceğiz.
    private static final int SCHEMA_VERSION=4;

    public DatabaseConnector(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String iller_Create_Table = "CREATE TABLE IF NOT EXISTS ili (Id INTEGER PRIMARY KEY,Name TEXT,Ulkesi TEXT)";

        String Insert_Iller_SQL = "INSERT INTO ili VALUES"+
                "(1, 'Adana','Türkiye'),"+
                "(2, 'Adıyaman','Türkiye'),"+
                "(3, 'Afyon','Türkiye'),"+
                "(4, 'Ağrı','Türkiye'),"+
                "(5, 'Amasya','Türkiye'),"+
                "(6, 'Ankara','Türkiye'),"+
                "(7, 'Antalya','Türkiye'),"+
                "(8, 'Artvin','Türkiye'),"+
                "(9, 'Aydın','Türkiye'),"+
                "(10,'Balıkesir','Türkiye'),"+
                "(11,'Bilecik','Türkiye'),"+
                "(12,'Bingöl','Türkiye'),"+
                "(13,'Bitlis','Türkiye'),"+
                "(14,'Bolu','Türkiye'),"+
                "(15,'Burdur','Türkiye'),"+
                "(16,'Bursa','Türkiye'),"+
                "(17,'Çanakkale','Türkiye'),"+
                "(18,'Çankırı','Türkiye'),"+
                "(19,'Çorum','Türkiye'),"+
                "(20,'Denizli','Türkiye'),"+
                "(21,'Diyarbakır','Türkiye'),"+
                "(22,'Edirne','Türkiye'),"+
                "(23,'Elazığ','Türkiye'),"+
                "(24,'Erzincan','Türkiye'),"+
                "(25,'Erzurum','Türkiye'),"+
                "(26,'Eskişehir','Türkiye'),"+
                "(27,'Gaziantep','Türkiye'),"+
                "(28,'Giresun','Türkiye'),"+
                "(29,'Gümüşhane','Türkiye'),"+
                "(30,'Hakkari','Türkiye'),"+
                "(31,'Hatay','Türkiye'),"+
                "(32,'Isparta','Türkiye'),"+
                "(33,'İçel','Türkiye'),"+
                "(34,'İstanbul','Türkiye'),"+
                "(35,'İzmir','Türkiye'),"+
                "(36,'Kars','Türkiye'),"+
                "(37,'Kastamonu','Türkiye'),"+
                "(38,'Kayseri','Türkiye'),"+
                "(39,'Kırklareli','Türkiye'),"+
                "(40,'Kırşehir','Türkiye'),"+
                "(41,'Kocaeli','Türkiye'),"+
                "(42,'Konya','Türkiye'),"+
                "(43,'Kütahya','Türkiye'),"+
                "(44,'Malatya','Türkiye'),"+
                "(45,'Manisa','Türkiye'),"+
                "(46,'K.Maraş','Türkiye'),"+
                "(47,'Mardin','Türkiye'),"+
                "(48,'Muğla','Türkiye'),"+
                "(49,'Muş','Türkiye'),"+
                "(50,'Nevşehir','Türkiye'),"+
                "(51,'Niğde','Türkiye'),"+
                "(52,'Ordu','Türkiye'),"+
                "(53,'Rize','Türkiye'),"+
                "(54,'Sakarya','Türkiye'),"+
                "(55,'Samsun','Türkiye'),"+
                "(56,'Siirt','Türkiye'),"+
                "(57,'Sinop','Türkiye'),"+
                "(58,'Sivas','Türkiye'),"+
                "(59,'Tekirdağ','Türkiye'),"+
                "(60,'Tokat','Türkiye'),"+
                "(61,'Trabzon','Türkiye'),"+
                "(62,'Tunceli','Türkiye'),"+
                "(63,'Şanlıurfa','Türkiye'),"+
                "(64,'Uşak','Türkiye'),"+
                "(65,'Van','Türkiye'),"+
                "(66,'Yozgat','Türkiye'),"+
                "(67,'Zonguldak','Türkiye'),"+
                "(68,'Aksaray','Türkiye'),"+
                "(69,'Bayburt','Türkiye'),"+
                "(70,'Karaman','Türkiye'),"+
                "(71,'Kırıkkale','Türkiye'),"+
                "(72,'Batman','Türkiye'),"+
                "(73,'Şırnak','Türkiye'),"+
                "(74,'Bartın','Türkiye'),"+
                "(75,'Ardahan','Türkiye'),"+
                "(76,'Iğdır','Türkiye'),"+
                "(77,'Yalova','Türkiye'),"+
                "(78,'Karabük','Türkiye'),"+
                "(79,'Kilis','Türkiye'),"+
                "(80,'Osmaniye','Türkiye'),"+
                "(81,'Düzce','Türkiye');";

        String Create_Table_Ilceler ="CREATE TABLE IF NOT EXISTS ilcesi (Id INTEGER PRIMARY KEY AUTOINCREMENT ,Ili  INTEGER, Kodu  INTEGER,Name TEXT);";
        String Insert_Ilceler_Sql ="INSERT INTO ilcesi VALUES\n" +
                "                (1, 1, 0, 'Merkez'),\n" +
                "                (2, 1, 20, 'Aladağ'),\n" +
                "                (3, 1, 28, 'Ceyhan'),\n" +
                "                (4, 1, 36, 'Feke'),\n" +
                "                (5, 1, 40, 'İmamoglu'),\n" +
                "                (6, 1, 48, 'Karaisalı'),\n" +
                "                (7, 1, 52, 'Karataş'),\n" +
                "                (8, 1, 56, 'Kozan'),\n" +
                "                (9, 1, 64, 'Pozantı'),\n" +
                "                (10, 1, 68, 'Saimbeyli'),\n" +
                "                (11, 1, 72, 'Seyhan'),\n" +
                "                (12, 1, 76, 'Tufanbeyli'),\n" +
                "                (13, 1, 80, 'Yumurtalık'),\n" +
                "                (14, 1, 84, 'Yüreğir'),\n" +
                "                (15, 2, 0, 'Merkez'),\n" +
                "                (16, 2, 20, 'Besni'),\n" +
                "                (17, 2, 25, 'Çelikhan'),\n" +
                "                (18, 2, 30, 'Gerger'),\n" +
                "                (19, 2, 35, 'Gölbaşı'),\n" +
                "                (20, 2, 40, 'Kahta'),\n" +
                "                (21, 2, 45, 'Samsat'),\n" +
                "                (22, 2, 50, 'Sıncık'),\n" +
                "                (23, 2, 55, 'Tut'),\n" +
                "                (24, 3, 0, 'Merkez'),\n" +
                "                (25, 3, 20, 'Basmakçı'),\n" +
                "                (26, 3, 24, 'Bayat'),\n" +
                "                (27, 3, 28, 'Bolvadin'),\n" +
                "                (28, 3, 32, 'Çobanlar'),\n" +
                "                (29, 3, 36, 'Çay'),\n" +
                "                (30, 3, 40, 'Dazkırı'),\n" +
                "                (31, 3, 44, 'Dinar'),\n" +
                "                (32, 3, 48, 'Emirdağ'),\n" +
                "                (33, 3, 52, 'Evciler'),\n" +
                "                (34, 3, 56, 'Hocalar'),\n" +
                "                (35, 3, 60, 'İhsaniye'),\n" +
                "                (36, 3, 64, 'İşcehisar'),\n" +
                "                (37, 3, 68, 'Kızılören'),\n" +
                "                (38, 3, 72, 'Sandiklı'),\n" +
                "                (39, 3, 76, 'Sincanlı'),\n" +
                "                (40, 3, 80, 'Sultandağı'),\n" +
                "                (41, 3, 84, 'Suhut'),\n" +
                "                (42, 4, 0, 'Merkez'),\n" +
                "                (43, 4, 20, 'Diyadin'),\n" +
                "                (44, 4, 25, 'Doğubeyazıt'),\n" +
                "                (45, 4, 30, 'Eleskirt'),\n" +
                "                (46, 4, 35, 'Hamur'),\n" +
                "                (47, 4, 40, 'Patnos'),\n" +
                "                (48, 4, 45, 'Taşlıçay'),\n" +
                "                (49, 4, 50, 'Tutak'),\n" +
                "                (50, 5, 0, 'Merkez'),\n" +
                "                (51, 5, 20, 'Göynücek'),\n" +
                "                (52, 5, 25, 'Gümüşhacıköy'),\n" +
                "                (53, 5, 30, 'Hamamözü'),\n" +
                "                (54, 5, 35, 'Merzifon'),\n" +
                "                (55, 5, 40, 'Suluova'),\n" +
                "                (56, 5, 45, 'Taşova'),\n" +
                "                (57, 6, 0, 'Merkez'),\n" +
                "                (58, 6, 20, 'Akyurt'),\n" +
                "                (59, 6, 23, 'Altındağ'),\n" +
                "                (60, 6, 26, 'Ayaş'),\n" +
                "                (61, 6, 29, 'Bala'),\n" +
                "                (62, 6, 32, 'Beypazarı'),\n" +
                "                (63, 6, 35, 'Çamlıdere'),\n" +
                "                (64, 6, 38, 'Çankaya'),\n" +
                "                (65, 6, 41, 'Çubuk'),\n" +
                "                (66, 6, 44, 'Elmadağ'),\n" +
                "                (67, 6, 47, 'Etimesgut'),\n" +
                "                (68, 6, 50, 'Evren'),\n" +
                "                (69, 6, 53, 'Gölbaşı'),\n" +
                "                (70, 6, 56, 'Güdül'),\n" +
                "                (71, 6, 59, 'Haymana'),\n" +
                "                (72, 6, 62, 'Kalecik'),\n" +
                "                (73, 6, 65, 'Kazan'),\n" +
                "                (74, 6, 68, 'Keçiören'),\n" +
                "                (75, 6, 71, 'Kızılcahamam'),\n" +
                "                (76, 6, 74, 'Mamak'),\n" +
                "                (77, 6, 77, 'Nallıhan'),\n" +
                "                (78, 6, 80, 'Polatlı'),\n" +
                "                (79, 6, 83, 'Sincan'),\n" +
                "                (80, 6, 86, 'Şereflikoçhisar'),\n" +
                "                (81, 6, 89, 'Yenimahalle'),\n" +
                "                (82, 7, 0, 'Merkez'),\n" +
                "                (83, 7, 20, 'Akseki'),\n" +
                "                (84, 7, 25, 'Alanya'),\n" +
                "                (85, 7, 28, 'Demre'),\n" +
                "                (86, 7, 30, 'Elmalı'),\n" +
                "                (87, 7, 35, 'Finike'),\n" +
                "                (88, 7, 40, 'Gazipaşa'),\n" +
                "                (89, 7, 45, 'Gündoğmuş'),\n" +
                "                (90, 7, 50, 'İbradi'),\n" +
                "                (91, 7, 55, 'Kale'),\n" +
                "                (92, 7, 60, 'Kas'),\n" +
                "                (93, 7, 65, 'Kemer'),\n" +
                "                (94, 7, 70, 'Korkuteli'),\n" +
                "                (95, 7, 75, 'Kumluca'),\n" +
                "                (96, 7, 80, 'Manavgat'),\n" +
                "                (97, 7, 85, 'Serik'),\n" +
                "                (98, 8, 0, 'Merkez'),\n" +
                "                (99, 8, 20, 'Ardanuç'),\n" +
                "                (100, 8, 25, 'Arhavi'),\n" +
                "                (101, 8, 30, 'Borçka'),\n" +
                "                (102, 8, 32, 'Hopa'),\n" +
                "                (103, 8, 35, 'Murgul'),\n" +
                "                (104, 8, 45, 'Savsat'),\n" +
                "                (105, 8, 50, 'Yusufeli'),\n" +
                "                (106, 9, 0, 'Merkez'),\n" +
                "                (107, 9, 20, 'Bozdoğan'),\n" +
                "                (108, 9, 24, 'Buharkent'),\n" +
                "                (109, 9, 28, 'Çine'),\n" +
                "                (110, 9, 32, 'Germencık'),\n" +
                "                (111, 9, 36, 'İncirliova'),\n" +
                "                (112, 9, 40, 'Karacasu'),\n" +
                "                (113, 9, 44, 'Karpuzlu'),\n" +
                "                (114, 9, 48, 'Koçarlı'),\n" +
                "                (115, 9, 52, 'Kösk'),\n" +
                "                (116, 9, 56, 'Kusadasi'),\n" +
                "                (117, 9, 60, 'Kuyucak'),\n" +
                "                (118, 9, 64, 'Nazilli'),\n" +
                "                (119, 9, 68, 'Söke'),\n" +
                "                (120, 9, 72, 'Sultanhisar'),\n" +
                "                (121, 9, 76, 'Yenihisar'),\n" +
                "                (122, 9, 80, 'Yenipazar'),\n" +
                "                (123, 10, 0, 'Merkez'),\n" +
                "                (124, 10, 20, 'Ayvalık'),\n" +
                "                (125, 10, 21, 'Akçay'),\n" +
                "                (126, 10, 24, 'Balya'),\n" +
                "                (127, 10, 28, 'Bandırma'),\n" +
                "                (128, 10, 32, 'Bigadiç'),\n" +
                "                (129, 10, 36, 'Burhaniye'),\n" +
                "                (130, 10, 40, 'Dursunbey'),\n" +
                "                (131, 10, 44, 'Edremit'),\n" +
                "                (132, 10, 48, 'Erdek'),\n" +
                "                (133, 10, 52, 'Gönen'),\n" +
                "                (134, 10, 56, 'Gömeç'),\n" +
                "                (135, 10, 60, 'Havran'),\n" +
                "                (136, 10, 64, 'İvrindi'),\n" +
                "                (137, 10, 68, 'Kepsut'),\n" +
                "                (138, 10, 72, 'Manyas'),\n" +
                "                (139, 10, 76, 'Marmara'),\n" +
                "                (140, 10, 80, 'Savaştepe'),\n" +
                "                (141, 10, 84, 'Sındırgı'),\n" +
                "                (142, 10, 88, 'Susurluk'),\n" +
                "                (143, 11, 0, 'Merkez'),\n" +
                "                (144, 11, 20, 'Bozöyük'),\n" +
                "                (145, 11, 25, 'Gölpazarı'),\n" +
                "                (146, 11, 30, 'İnhisar'),\n" +
                "                (147, 11, 35, 'Osmaneli'),\n" +
                "                (148, 11, 40, 'Pazaryeri'),\n" +
                "                (149, 11, 45, 'Söğüt'),\n" +
                "                (150, 11, 50, 'Yenipazar'),\n" +
                "                (151, 12, 0, 'Merkez'),\n" +
                "                (152, 12, 20, 'Adaklı'),\n" +
                "                (153, 12, 25, 'Genç'),\n" +
                "                (154, 12, 30, 'Karlıova'),\n" +
                "                (155, 12, 35, 'Kigi'),\n" +
                "                (156, 12, 40, 'Solhan'),\n" +
                "                (157, 12, 45, 'Yayladere'),\n" +
                "                (158, 12, 55, 'Yedisu'),\n" +
                "                (159, 13, 0, 'Merkez'),\n" +
                "                (160, 13, 20, 'Adilcevaz'),\n" +
                "                (161, 13, 25, 'Ahlat'),\n" +
                "                (162, 13, 30, 'Güroymak'),\n" +
                "                (163, 13, 35, 'Hizan'),\n" +
                "                (164, 13, 40, 'Mutki'),\n" +
                "                (165, 13, 45, 'Tatvan'),\n" +
                "                (166, 14, 0, 'Merkez'),\n" +
                "                (167, 14, 35, 'Dörtdivan'),\n" +
                "                (168, 14, 45, 'Gerede'),\n" +
                "                (169, 14, 55, 'Göynük'),\n" +
                "                (170, 14, 60, 'Kıbrıscık'),\n" +
                "                (171, 14, 65, 'Mengen'),\n" +
                "                (172, 14, 70, 'Mudurnu'),\n" +
                "                (173, 14, 75, 'Seben'),\n" +
                "                (174, 14, 80, 'Yeniçağa'),\n" +
                "                (175, 15, 0, 'Merkez'),\n" +
                "                (176, 15, 20, 'Altınyayla'),\n" +
                "                (177, 15, 25, 'Aglasun'),\n" +
                "                (178, 15, 30, 'Bucak'),\n" +
                "                (179, 15, 35, 'Çavdir'),\n" +
                "                (180, 15, 40, 'Çeltikçi'),\n" +
                "                (181, 15, 45, 'Gölhisar'),\n" +
                "                (182, 15, 50, 'Karamanlı'),\n" +
                "                (183, 15, 55, 'Kemer'),\n" +
                "                (184, 15, 60, 'Tefenni'),\n" +
                "                (185, 15, 65, 'Yesilova'),\n" +
                "                (186, 16, 0, 'Merkez'),\n" +
                "                (187, 16, 24, 'Büyükorhan'),\n" +
                "                (188, 16, 28, 'Gemlik'),\n" +
                "                (189, 16, 32, 'Gürsu'),\n" +
                "                (190, 16, 36, 'Harmancık'),\n" +
                "                (191, 16, 40, 'İnegöl'),\n" +
                "                (192, 16, 44, 'İznik'),\n" +
                "                (193, 16, 48, 'Karacabey'),\n" +
                "                (194, 16, 52, 'Keles'),\n" +
                "                (195, 16, 56, 'Kestel'),\n" +
                "                (196, 16, 60, 'Mudanya'),\n" +
                "                (197, 16, 64, 'Mustafakema'),\n" +
                "                (198, 16, 68, 'Nilüfer'),\n" +
                "                (199, 16, 72, 'Orhaneli'),\n" +
                "                (200, 16, 76, 'Orhangazi'),\n" +
                "                (201, 16, 80, 'Osmangazi'),\n" +
                "                (202, 16, 84, 'Yenisehir'),\n" +
                "                (203, 16, 88, 'Yıldırım'),\n" +
                "                (204, 17, 0, 'Merkez'),\n" +
                "                (205, 17, 25, 'Ayvacık'),\n" +
                "                (206, 17, 30, 'Bayramiç'),\n" +
                "                (207, 17, 32, 'Bozcaada'),\n" +
                "                (208, 17, 35, 'Biga'),\n" +
                "                (209, 17, 40, 'Çan'),\n" +
                "                (210, 17, 45, 'Eceabat'),\n" +
                "                (211, 17, 50, 'Ezine'),\n" +
                "                (212, 17, 55, 'Gelibolu'),\n" +
                "                (213, 17, 57, 'Gökçeada'),\n" +
                "                (214, 17, 65, 'Lapseki'),\n" +
                "                (215, 17, 70, 'Yenice'),\n" +
                "                (216, 18, 0, 'Merkez'),\n" +
                "                (217, 18, 25, 'Atkaracalar'),\n" +
                "                (218, 18, 30, 'Bayramören'),\n" +
                "                (219, 18, 35, 'Çerkes'),\n" +
                "                (220, 18, 40, 'Eldivan'),\n" +
                "                (221, 18, 50, 'Ilgaz'),\n" +
                "                (222, 18, 55, 'Kızılkırmak'),\n" +
                "                (223, 18, 60, 'Korgun'),\n" +
                "                (224, 18, 65, 'Kurşunlu'),\n" +
                "                (225, 18, 70, 'Orta'),\n" +
                "                (226, 18, 75, 'Ovacık'),\n" +
                "                (227, 18, 80, 'Şabanözü'),\n" +
                "                (228, 18, 85, 'Yapraklı'),\n" +
                "                (229, 19, 0, 'Merkez'),\n" +
                "                (230, 19, 25, 'Alaca'),\n" +
                "                (231, 19, 30, 'Bayat'),\n" +
                "                (232, 19, 35, 'Bogazkale'),\n" +
                "                (233, 19, 40, 'Dodurga'),\n" +
                "                (234, 19, 45, 'İskilip'),\n" +
                "                (235, 19, 50, 'Kargı'),\n" +
                "                (236, 19, 55, 'Laçin'),\n" +
                "                (237, 19, 60, 'Mecitözü'),\n" +
                "                (238, 19, 65, 'Oğuzlar'),\n" +
                "                (239, 19, 70, 'Ortaköy'),\n" +
                "                (240, 19, 75, 'Osmancık'),\n" +
                "                (241, 19, 80, 'Sungurlu'),\n" +
                "                (242, 19, 85, 'Ugurludağ'),\n" +
                "                (243, 20, 0, 'Merkez'),\n" +
                "                (244, 20, 23, 'Acıpayam'),\n" +
                "                (245, 20, 26, 'Akköy'),\n" +
                "                (246, 20, 29, 'Babadağ'),\n" +
                "                (247, 20, 32, 'Baklan'),\n" +
                "                (248, 20, 35, 'Bekilli'),\n" +
                "                (249, 20, 38, 'Beyağaç'),\n" +
                "                (250, 20, 41, 'Buldan'),\n" +
                "                (251, 20, 44, 'Bozkurt'),\n" +
                "                (252, 20, 47, 'Çal'),\n" +
                "                (253, 20, 50, 'Çameli'),\n" +
                "                (254, 20, 53, 'Çardak'),\n" +
                "                (255, 20, 56, 'Çivril'),\n" +
                "                (256, 20, 59, 'Güney'),\n" +
                "                (257, 20, 62, 'Honaz'),\n" +
                "                (258, 20, 65, 'Kale'),\n" +
                "                (259, 20, 68, 'Sarayköy'),\n" +
                "                (260, 20, 71, 'Serinhisar'),\n" +
                "                (261, 20, 74, 'Tavas'),\n" +
                "                (262, 21, 0, 'Merkez'),\n" +
                "                (263, 21, 25, 'Bismil'),\n" +
                "                (264, 21, 30, 'Çermik'),\n" +
                "                (265, 21, 35, 'Çınar'),\n" +
                "                (266, 21, 40, 'Çüngüs'),\n" +
                "                (267, 21, 45, 'Dicle'),\n" +
                "                (268, 21, 50, 'Egil'),\n" +
                "                (269, 21, 55, 'Ergani'),\n" +
                "                (270, 21, 60, 'Hani'),\n" +
                "                (271, 21, 65, 'Hazro'),\n" +
                "                (272, 21, 70, 'Kocaköy'),\n" +
                "                (273, 21, 75, 'Kulp'),\n" +
                "                (274, 21, 80, 'Lice'),\n" +
                "                (275, 21, 85, 'Silvan'),\n" +
                "                (276, 22, 0, 'Merkez'),\n" +
                "                (277, 22, 25, 'Enez'),\n" +
                "                (278, 22, 30, 'Havsa'),\n" +
                "                (279, 22, 35, 'Ipsala'),\n" +
                "                (280, 22, 40, 'Kesan'),\n" +
                "                (281, 22, 45, 'Lalapaşa'),\n" +
                "                (282, 22, 50, 'Meriç'),\n" +
                "                (283, 22, 55, 'Süloglu'),\n" +
                "                (284, 22, 60, 'Uzunköprü'),\n" +
                "                (285, 23, 0, 'Merkez'),\n" +
                "                (286, 23, 25, 'Ağın'),\n" +
                "                (287, 23, 30, 'Alacakaya'),\n" +
                "                (288, 23, 35, 'Arıcak'),\n" +
                "                (289, 23, 40, 'Baskil'),\n" +
                "                (290, 23, 45, 'Karakoçan'),\n" +
                "                (291, 23, 50, 'Keban'),\n" +
                "                (292, 23, 55, 'Kovancılar'),\n" +
                "                (293, 23, 60, 'Maden'),\n" +
                "                (294, 23, 65, 'Palu'),\n" +
                "                (295, 23, 70, 'Sivrice'),\n" +
                "                (296, 24, 0, 'Merkez'),\n" +
                "                (297, 24, 25, 'Çayırlı'),\n" +
                "                (298, 24, 30, 'İliç'),\n" +
                "                (299, 24, 35, 'Kemah'),\n" +
                "                (300, 24, 40, 'Kemaliye'),\n" +
                "                (301, 24, 45, 'Otlukbeli'),\n" +
                "                (302, 24, 50, 'Refahiye'),\n" +
                "                (303, 24, 55, 'Tercan'),\n" +
                "                (304, 24, 60, 'Üzümlü'),\n" +
                "                (305, 25, 0, 'Merkez'),\n" +
                "                (306, 25, 23, 'Aşkale'),\n" +
                "                (307, 25, 26, 'Çat'),\n" +
                "                (308, 25, 29, 'Hinis'),\n" +
                "                (309, 25, 32, 'Horasan'),\n" +
                "                (310, 25, 35, 'Ilıca'),\n" +
                "                (311, 25, 38, 'İspir'),\n" +
                "                (312, 25, 41, 'Karaçoban'),\n" +
                "                (313, 25, 44, 'Karayazı'),\n" +
                "                (314, 25, 47, 'Köprüköy'),\n" +
                "                (315, 25, 50, 'Narman'),\n" +
                "                (316, 25, 53, 'Oltu'),\n" +
                "                (317, 25, 55, 'Olur'),\n" +
                "                (318, 25, 58, 'Pasinler'),\n" +
                "                (319, 25, 61, 'Pazaryolu'),\n" +
                "                (320, 25, 64, 'Senkaya'),\n" +
                "                (321, 25, 67, 'Tekman'),\n" +
                "                (322, 25, 70, 'Tortum'),\n" +
                "                (323, 25, 73, 'Uzundere'),\n" +
                "                (324, 26, 0, 'Merkez'),\n" +
                "                (325, 26, 25, 'Alpu'),\n" +
                "                (326, 26, 30, 'Beylikova'),\n" +
                "                (327, 26, 35, 'Çifteler'),\n" +
                "                (328, 26, 40, 'Günyüzü'),\n" +
                "                (329, 26, 45, 'Han'),\n" +
                "                (330, 26, 50, 'Inönü'),\n" +
                "                (331, 26, 55, 'Mahmudiye'),\n" +
                "                (332, 26, 60, 'Mihalgazi'),\n" +
                "                (333, 26, 65, 'Mihaliççik'),\n" +
                "                (334, 26, 70, 'Sarıcakaya'),\n" +
                "                (335, 26, 75, 'Seyitgazi'),\n" +
                "                (336, 26, 80, 'Sivrihisar'),\n" +
                "                (337, 27, 0, 'Merkez'),\n" +
                "                (338, 27, 25, 'Araban'),\n" +
                "                (339, 27, 30, 'Islahiye'),\n" +
                "                (340, 27, 35, 'Kilis'),\n" +
                "                (341, 27, 40, 'Kargamış'),\n" +
                "                (342, 27, 45, 'Nizip'),\n" +
                "                (343, 27, 50, 'Nurdağı'),\n" +
                "                (344, 27, 55, 'Oğuzeli'),\n" +
                "                (345, 27, 60, 'Sahinbey'),\n" +
                "                (346, 27, 65, 'Sehitkamil'),\n" +
                "                (347, 27, 70, 'Yavuzeli'),\n" +
                "                (348, 28, 0, 'Merkez'),\n" +
                "                (349, 28, 25, 'Alucra'),\n" +
                "                (350, 28, 30, 'Bulancak'),\n" +
                "                (351, 28, 32, 'Çamoluk'),\n" +
                "                (352, 28, 35, 'Çanakçı'),\n" +
                "                (353, 28, 40, 'Dereli'),\n" +
                "                (354, 28, 42, 'Doğankent'),\n" +
                "                (355, 28, 45, 'Espiye'),\n" +
                "                (356, 28, 50, 'Eynesil'),\n" +
                "                (357, 28, 55, 'Görele'),\n" +
                "                (358, 28, 60, 'Güce'),\n" +
                "                (359, 28, 65, 'Kesap'),\n" +
                "                (360, 28, 70, 'Piraziz'),\n" +
                "                (361, 28, 75, 'Şebinkarahisar'),\n" +
                "                (362, 28, 80, 'Tirebolu'),\n" +
                "                (363, 28, 85, 'Yağlıdere'),\n" +
                "                (364, 29, 0, 'Merkez'),\n" +
                "                (365, 29, 25, 'Kelkit'),\n" +
                "                (366, 29, 30, 'Köse'),\n" +
                "                (367, 29, 35, 'Kürtün'),\n" +
                "                (368, 29, 40, 'Siran'),\n" +
                "                (369, 29, 45, 'Torul'),\n" +
                "                (370, 30, 0, 'Merkez'),\n" +
                "                (371, 30, 25, 'Çukurca'),\n" +
                "                (372, 30, 30, 'Semdinli'),\n" +
                "                (373, 30, 35, 'Yüksekova'),\n" +
                "                (374, 31, 0, 'Merkez'),\n" +
                "                (375, 31, 25, 'Altınözü'),\n" +
                "                (376, 31, 30, 'Belen'),\n" +
                "                (377, 31, 35, 'Dörtyol'),\n" +
                "                (378, 31, 40, 'Erzin'),\n" +
                "                (379, 31, 45, 'Hassa'),\n" +
                "                (380, 31, 50, 'İskenderun'),\n" +
                "                (381, 31, 55, 'Kırıkhan'),\n" +
                "                (382, 31, 60, 'Kumlu'),\n" +
                "                (383, 31, 65, 'Reyhanlı'),\n" +
                "                (384, 31, 70, 'Samandağı'),\n" +
                "                (385, 31, 75, 'Yayladağı'),\n" +
                "                (386, 32, 0, 'Merkez'),\n" +
                "                (387, 32, 25, 'Aksu'),\n" +
                "                (388, 32, 30, 'Atabey'),\n" +
                "                (389, 32, 35, 'Egirdir'),\n" +
                "                (390, 32, 40, 'Gelendost'),\n" +
                "                (391, 32, 45, 'Gönen'),\n" +
                "                (392, 32, 50, 'Keçiborlu'),\n" +
                "                (393, 32, 55, 'Senirkent'),\n" +
                "                (394, 32, 60, 'Sütçüler'),\n" +
                "                (395, 32, 65, 'Sarkikaraag'),\n" +
                "                (396, 32, 70, 'Uluborlu'),\n" +
                "                (397, 32, 75, 'Yenisarbade'),\n" +
                "                (398, 32, 80, 'Yalvaç'),\n" +
                "                (399, 33, 0, 'Merkez'),\n" +
                "                (400, 33, 25, 'Anamur'),\n" +
                "                (401, 33, 30, 'Aydıncık'),\n" +
                "                (402, 33, 35, 'Bozyazı'),\n" +
                "                (403, 33, 40, 'Çamlıyayla'),\n" +
                "                (404, 33, 45, 'Erdemli'),\n" +
                "                (405, 33, 50, 'Gülnar'),\n" +
                "                (406, 33, 55, 'Mut'),\n" +
                "                (407, 33, 60, 'Silifke'),\n" +
                "                (408, 33, 65, 'Tarsus'),\n" +
                "                (409, 34, 0, 'Merkez'),\n" +
                "                (410, 34, 23, 'Adalar'),\n" +
                "                (411, 34, 24, 'Avcilar'),\n" +
                "                (412, 34, 25, 'Bagcilar'),\n" +
                "                (413, 34, 26, 'Bakirköy'),\n" +
                "                (414, 34, 27, 'Bahçelievle'),\n" +
                "                (415, 34, 29, 'Bayrampaşa'),\n" +
                "                (416, 34, 32, 'Besiktaş'),\n" +
                "                (417, 34, 35, 'Beykoz'),\n" +
                "                (418, 34, 38, 'Beyoglu'),\n" +
                "                (419, 34, 41, 'Büyükçekmece'),\n" +
                "                (420, 34, 44, 'Çatalca'),\n" +
                "                (421, 34, 47, 'Eminönü'),\n" +
                "                (422, 34, 50, 'Eyüp'),\n" +
                "                (423, 34, 51, 'Esenler'),\n" +
                "                (424, 34, 53, 'Fatih'),\n" +
                "                (425, 34, 56, 'Gaziosmanpaşa'),\n" +
                "                (426, 34, 57, 'Güngören'),\n" +
                "                (427, 34, 59, 'Kadıköy'),\n" +
                "                (428, 34, 61, 'Kağıthane'),\n" +
                "                (429, 34, 64, 'Kartal'),\n" +
                "                (430, 34, 67, 'Küçükçekmece'),\n" +
                "                (431, 34, 68, 'Maltepe'),\n" +
                "                (432, 34, 70, 'Pendik'),\n" +
                "                (433, 34, 73, 'Sarıyer'),\n" +
                "                (434, 34, 76, 'Silivri'),\n" +
                "                (435, 34, 77, 'Sultanbeyli'),\n" +
                "                (436, 34, 79, 'Sile'),\n" +
                "                (437, 34, 81, 'Sisli'),\n" +
                "                (438, 34, 82, 'Tuzla'),\n" +
                "                (439, 34, 84, 'Ümraniye'),\n" +
                "                (440, 34, 87, 'Üsküdar'),\n" +
                "                (441, 34, 90, 'Yalova'),\n" +
                "                (442, 34, 93, 'Zeytinburnu'),\n" +
                "                (443, 35, 0, 'Merkez'),\n" +
                "                (444, 35, 23, 'Aliağa'),\n" +
                "                (445, 35, 26, 'Bayindir'),\n" +
                "                (446, 35, 27, 'Balçova'),\n" +
                "                (447, 35, 29, 'Bergama'),\n" +
                "                (448, 35, 32, 'Beydağ'),\n" +
                "                (449, 35, 35, 'Bornova'),\n" +
                "                (450, 35, 37, 'Buca'),\n" +
                "                (451, 35, 41, 'Çesme'),\n" +
                "                (452, 35, 42, 'Çiğli'),\n" +
                "                (453, 35, 44, 'Dikili'),\n" +
                "                (454, 35, 47, 'Foça'),\n" +
                "                (455, 35, 48, 'Gaziemir'),\n" +
                "                (456, 35, 49, 'Güzelbahçe'),\n" +
                "                (457, 35, 50, 'Karaburun'),\n" +
                "                (458, 35, 53, 'Karşıyaka'),\n" +
                "                (459, 35, 56, 'Kemalpaşa'),\n" +
                "                (460, 35, 59, 'Kinik'),\n" +
                "                (461, 35, 62, 'Kiraz'),\n" +
                "                (462, 35, 65, 'Konak'),\n" +
                "                (463, 35, 68, 'Menderes'),\n" +
                "                (464, 35, 71, 'Menemen'),\n" +
                "                (465, 35, 72, 'Narlıdere'),\n" +
                "                (466, 35, 74, 'Ödemiş'),\n" +
                "                (467, 35, 77, 'Seferihisar'),\n" +
                "                (468, 35, 80, 'Selçuk'),\n" +
                "                (469, 35, 83, 'Tire'),\n" +
                "                (470, 35, 86, 'Torbali'),\n" +
                "                (471, 35, 89, 'Urla'),\n" +
                "                (472, 36, 0, 'Merkez'),\n" +
                "                (473, 36, 24, 'Akyaka'),\n" +
                "                (474, 36, 36, 'Arpaçay'),\n" +
                "                (475, 36, 44, 'Digor'),\n" +
                "                (476, 36, 60, 'Kağizman'),\n" +
                "                (477, 36, 68, 'Sarıkamış'),\n" +
                "                (478, 36, 72, 'Selim'),\n" +
                "                (479, 36, 76, 'Susuz'),\n" +
                "                (480, 37, 0, 'Merkez'),\n" +
                "                (481, 37, 23, 'Abana'),\n" +
                "                (482, 37, 26, 'Ağlı'),\n" +
                "                (483, 37, 29, 'Araç'),\n" +
                "                (484, 37, 32, 'Azdavay'),\n" +
                "                (485, 37, 35, 'Bozkurt'),\n" +
                "                (486, 37, 38, 'Cide'),\n" +
                "                (487, 37, 41, 'Çatalzeytin'),\n" +
                "                (488, 37, 44, 'Daday'),\n" +
                "                (489, 37, 47, 'Devrekani'),\n" +
                "                (490, 37, 50, 'Doğanyurt'),\n" +
                "                (491, 37, 53, 'Hanönü'),\n" +
                "                (492, 37, 56, 'İhsangazi'),\n" +
                "                (493, 37, 59, 'İnebolu'),\n" +
                "                (494, 37, 62, 'Küre'),\n" +
                "                (495, 37, 65, 'Pınarbaşı'),\n" +
                "                (496, 37, 68, 'Seydiler'),\n" +
                "                (497, 37, 71, 'Senpazar'),\n" +
                "                (498, 37, 74, 'Taşköprü'),\n" +
                "                (499, 37, 77, 'Tosya'),\n" +
                "                (500, 38, 0, 'Merkez'),\n" +
                "                (501, 38, 24, 'Akkışla'),\n" +
                "                (502, 38, 28, 'Bünyan'),\n" +
                "                (503, 38, 32, 'Develi'),\n" +
                "                (504, 38, 36, 'Felahiye'),\n" +
                "                (505, 38, 40, 'Hacılar'),\n" +
                "                (506, 38, 44, 'İncesu'),\n" +
                "                (507, 38, 48, 'Kocasinan'),\n" +
                "                (508, 38, 52, 'Melikgazi'),\n" +
                "                (509, 38, 56, 'Özvatan'),\n" +
                "                (510, 38, 60, 'Pınarbaşı'),\n" +
                "                (511, 38, 64, 'Sarıoglan'),\n" +
                "                (512, 38, 68, 'Sarız'),\n" +
                "                (513, 38, 72, 'Talas'),\n" +
                "                (514, 38, 76, 'Tomarza'),\n" +
                "                (515, 38, 80, 'Yahyali'),\n" +
                "                (516, 38, 84, 'Yesilhisar'),\n" +
                "                (517, 39, 0, 'Merkez'),\n" +
                "                (518, 39, 25, 'Babaeski'),\n" +
                "                (519, 39, 30, 'Demirköy'),\n" +
                "                (520, 39, 35, 'Kofçaz'),\n" +
                "                (521, 39, 40, 'Lüleburgaz'),\n" +
                "                (522, 39, 45, 'Pehlivanköy'),\n" +
                "                (523, 39, 50, 'Pınarhisar'),\n" +
                "                (524, 39, 55, 'Vize'),\n" +
                "                (525, 40, 0, 'Merkez'),\n" +
                "                (526, 40, 20, 'Akçakent'),\n" +
                "                (527, 40, 25, 'Akpınar'),\n" +
                "                (528, 40, 27, 'Boztepe'),\n" +
                "                (529, 40, 30, 'Çiçekdağı'),\n" +
                "                (530, 40, 35, 'Kaman'),\n" +
                "                (531, 40, 40, 'Mucur'),\n" +
                "                (532, 41, 0, 'Merkez'),\n" +
                "                (533, 41, 20, 'Darıca'),\n" +
                "                (534, 41, 25, 'Gebze'),\n" +
                "                (535, 41, 30, 'Gölcük'),\n" +
                "                (536, 41, 35, 'Kandıra'),\n" +
                "                (537, 41, 40, 'Karamürsel'),\n" +
                "                (538, 41, 45, 'Körfez'),\n" +
                "                (539, 42, 0, 'Merkez'),\n" +
                "                (540, 42, 22, 'Ahirli'),\n" +
                "                (541, 42, 24, 'Akören'),\n" +
                "                (542, 42, 26, 'Aksehir'),\n" +
                "                (543, 42, 28, 'Altınekin'),\n" +
                "                (544, 42, 30, 'Beysehir'),\n" +
                "                (545, 42, 32, 'Bozkir'),\n" +
                "                (546, 42, 34, 'Derebucak'),\n" +
                "                (547, 42, 36, 'Cihanbeyli'),\n" +
                "                (548, 42, 38, 'Çumra'),\n" +
                "                (549, 42, 40, 'Çeltik'),\n" +
                "                (550, 42, 42, 'Derbent'),\n" +
                "                (551, 42, 44, 'Doğanhisar'),\n" +
                "                (552, 42, 46, 'Emirgazi'),\n" +
                "                (553, 42, 48, 'Eregli'),\n" +
                "                (554, 42, 50, 'Güneysinir'),\n" +
                "                (555, 42, 52, 'Halkapınar'),\n" +
                "                (556, 42, 54, 'Hadim'),\n" +
                "                (557, 42, 55, 'Halkapınar'),\n" +
                "                (558, 42, 56, 'Hüyük'),\n" +
                "                (559, 42, 58, 'Ilgin'),\n" +
                "                (560, 42, 60, 'Kadinhani'),\n" +
                "                (561, 42, 62, 'Karapınar'),\n" +
                "                (562, 42, 64, 'Karatay'),\n" +
                "                (563, 42, 66, 'Kulu'),\n" +
                "                (564, 42, 68, 'Meram'),\n" +
                "                (565, 42, 70, 'Sarayönü'),\n" +
                "                (566, 42, 72, 'Selçuklu'),\n" +
                "                (567, 42, 74, 'Seydisehir'),\n" +
                "                (568, 42, 76, 'Taşkent'),\n" +
                "                (569, 42, 78, 'Tuzlukçu'),\n" +
                "                (570, 42, 80, 'Yalihöyük'),\n" +
                "                (571, 42, 82, 'Yunak'),\n" +
                "                (572, 43, 0, 'Merkez'),\n" +
                "                (573, 43, 25, 'Altıntaş'),\n" +
                "                (574, 43, 30, 'Aslanapa'),\n" +
                "                (575, 43, 35, 'Cavdarhisar'),\n" +
                "                (576, 43, 40, 'Domaniç'),\n" +
                "                (577, 43, 45, 'Dumlupınar'),\n" +
                "                (578, 43, 50, 'Emet'),\n" +
                "                (579, 43, 55, 'Gediz'),\n" +
                "                (580, 43, 60, 'Hisarcık'),\n" +
                "                (581, 43, 65, 'Pazarlar'),\n" +
                "                (582, 43, 70, 'Simav'),\n" +
                "                (583, 43, 75, 'Saphane'),\n" +
                "                (584, 43, 80, 'Tavsanlı'),\n" +
                "                (585, 44, 0, 'Merkez'),\n" +
                "                (586, 44, 25, 'Akçadağ'),\n" +
                "                (587, 44, 30, 'Arapgir'),\n" +
                "                (588, 44, 35, 'Arguvan'),\n" +
                "                (589, 44, 40, 'Battalgazi'),\n" +
                "                (590, 44, 45, 'Darende'),\n" +
                "                (591, 44, 50, 'Doğansehir'),\n" +
                "                (592, 44, 55, 'Doğanyol'),\n" +
                "                (593, 44, 60, 'Hekimhan'),\n" +
                "                (594, 44, 65, 'Kale'),\n" +
                "                (595, 44, 70, 'Kuluncak'),\n" +
                "                (596, 44, 75, 'Pötürge'),\n" +
                "                (597, 44, 80, 'Yazıhan'),\n" +
                "                (598, 44, 85, 'Yesilyurt'),\n" +
                "                (599, 45, 0, 'Merkez'),\n" +
                "                (600, 45, 25, 'Ahmetli'),\n" +
                "                (601, 45, 30, 'Akhisar'),\n" +
                "                (602, 45, 35, 'Alasehir'),\n" +
                "                (603, 45, 40, 'Demirci'),\n" +
                "                (604, 45, 45, 'Gölmarmara'),\n" +
                "                (605, 45, 50, 'Gördes'),\n" +
                "                (606, 45, 55, 'Kirkağaç'),\n" +
                "                (607, 45, 60, 'Köprübaşı'),\n" +
                "                (608, 45, 65, 'Kula'),\n" +
                "                (609, 45, 70, 'Salihli'),\n" +
                "                (610, 45, 75, 'Sarıgöl'),\n" +
                "                (611, 45, 80, 'Saruhanlı'),\n" +
                "                (612, 45, 85, 'Selendi'),\n" +
                "                (613, 45, 90, 'Soma'),\n" +
                "                (614, 45, 95, 'Turgutlu'),\n" +
                "                (615, 46, 0, 'Merkez'),\n" +
                "                (616, 46, 25, 'Afşin'),\n" +
                "                (617, 46, 30, 'Andırın'),\n" +
                "                (618, 46, 35, 'Çaglayancer'),\n" +
                "                (619, 46, 40, 'Ekinözü'),\n" +
                "                (620, 46, 45, 'Elbistan'),\n" +
                "                (621, 46, 50, 'Göksun'),\n" +
                "                (622, 46, 55, 'Nurhak'),\n" +
                "                (623, 46, 60, 'Pazarcık'),\n" +
                "                (624, 46, 65, 'Türkoglu'),\n" +
                "                (625, 47, 0, 'Merkez'),\n" +
                "                (626, 47, 25, 'Dargeçit'),\n" +
                "                (627, 47, 30, 'Derik'),\n" +
                "                (628, 47, 40, 'Kızıltepe'),\n" +
                "                (629, 47, 45, 'Mazidağı'),\n" +
                "                (630, 47, 50, 'Midyat'),\n" +
                "                (631, 47, 55, 'Nusaybin'),\n" +
                "                (632, 47, 60, 'Ömerli'),\n" +
                "                (633, 47, 65, 'Savur'),\n" +
                "                (634, 47, 70, 'Yesilli'),\n" +
                "                (635, 48, 0, 'Merkez'),\n" +
                "                (636, 48, 25, 'Bodrum'),\n" +
                "                (637, 48, 30, 'Dalaman'),\n" +
                "                (638, 48, 35, 'Datça'),\n" +
                "                (639, 48, 40, 'Fethiye'),\n" +
                "                (640, 48, 45, 'Kavaklıdere'),\n" +
                "                (641, 48, 50, 'Köycegiz'),\n" +
                "                (642, 48, 55, 'Marmaris'),\n" +
                "                (643, 48, 60, 'Milas'),\n" +
                "                (644, 48, 65, 'Ortaca'),\n" +
                "                (645, 48, 70, 'Ula'),\n" +
                "                (646, 48, 75, 'Yatağan'),\n" +
                "                (647, 49, 0, 'Merkez'),\n" +
                "                (648, 49, 25, 'Bulanik'),\n" +
                "                (649, 49, 30, 'Hasköy'),\n" +
                "                (650, 49, 35, 'Korkut'),\n" +
                "                (651, 49, 40, 'Malazgirt'),\n" +
                "                (652, 49, 45, 'Varto'),\n" +
                "                (653, 50, 0, 'Merkez'),\n" +
                "                (654, 50, 25, 'Acıgöl'),\n" +
                "                (655, 50, 30, 'Avanos'),\n" +
                "                (656, 50, 35, 'Derinkuyu'),\n" +
                "                (657, 50, 40, 'Gülsehir'),\n" +
                "                (658, 50, 45, 'Hacıbektaş'),\n" +
                "                (659, 50, 50, 'Kozaklı'),\n" +
                "                (660, 50, 55, 'Ürgüp'),\n" +
                "                (661, 51, 0, 'Merkez'),\n" +
                "                (662, 51, 25, 'Altunhisar'),\n" +
                "                (663, 51, 30, 'Bor'),\n" +
                "                (664, 51, 35, 'Çamardı'),\n" +
                "                (665, 51, 40, 'Çiftlik'),\n" +
                "                (666, 51, 45, 'Ulukışla'),\n" +
                "                (667, 52, 0, 'Merkez'),\n" +
                "                (668, 52, 23, 'Akkus'),\n" +
                "                (669, 52, 26, 'Aybasti'),\n" +
                "                (670, 52, 29, 'Çamas'),\n" +
                "                (671, 52, 32, 'Çatalpınar'),\n" +
                "                (672, 52, 35, 'Çaybaşı'),\n" +
                "                (673, 52, 38, 'Fatsa'),\n" +
                "                (674, 52, 41, 'Gölköy'),\n" +
                "                (675, 52, 44, 'Gölyali'),\n" +
                "                (676, 52, 47, 'Gürgentepe'),\n" +
                "                (677, 52, 50, 'İkizce'),\n" +
                "                (678, 52, 53, 'Korgan'),\n" +
                "                (679, 52, 56, 'Kabadüz'),\n" +
                "                (680, 52, 59, 'Kabataş'),\n" +
                "                (681, 52, 62, 'Kumru'),\n" +
                "                (682, 52, 65, 'Mesudiye'),\n" +
                "                (683, 52, 68, 'Persembe'),\n" +
                "                (684, 52, 71, 'Ulubey'),\n" +
                "                (685, 52, 74, 'Ünye'),\n" +
                "                (686, 53, 0, 'Merkez'),\n" +
                "                (687, 53, 25, 'Ardesen'),\n" +
                "                (688, 53, 30, 'Çamlıhemşin'),\n" +
                "                (689, 53, 35, 'Çayeli'),\n" +
                "                (690, 53, 40, 'Derepazarı'),\n" +
                "                (691, 53, 45, 'Fındıklı'),\n" +
                "                (692, 53, 50, 'Güneysu'),\n" +
                "                (693, 53, 55, 'Hemsin'),\n" +
                "                (694, 53, 60, 'İkizdere'),\n" +
                "                (695, 53, 65, 'İyidere'),\n" +
                "                (696, 53, 70, 'Kalkandere'),\n" +
                "                (697, 53, 75, 'Pazar'),\n" +
                "                (698, 54, 0, 'Merkez'),\n" +
                "                (699, 54, 25, 'Akyazı'),\n" +
                "                (700, 54, 30, 'Ferizli'),\n" +
                "                (701, 54, 35, 'Geyve'),\n" +
                "                (702, 54, 40, 'Hendek'),\n" +
                "                (703, 54, 45, 'Karapürçek'),\n" +
                "                (704, 54, 50, 'Karasu'),\n" +
                "                (705, 54, 55, 'Kaynarca'),\n" +
                "                (706, 54, 60, 'Kocaali'),\n" +
                "                (707, 54, 65, 'Pamukova'),\n" +
                "                (708, 54, 70, 'Sapanca'),\n" +
                "                (709, 54, 75, 'Söğütlü'),\n" +
                "                (710, 54, 80, 'Taraklı'),\n" +
                "                (711, 55, 0, 'Merkez'),\n" +
                "                (712, 55, 25, 'Alaçam'),\n" +
                "                (713, 55, 30, 'Asarcık'),\n" +
                "                (714, 55, 35, 'Ayvacık'),\n" +
                "                (715, 55, 40, 'Bafra'),\n" +
                "                (716, 55, 45, 'Çarşamba'),\n" +
                "                (717, 55, 50, 'Havza'),\n" +
                "                (718, 55, 55, 'Kavak'),\n" +
                "                (719, 55, 60, 'Ladik'),\n" +
                "                (720, 55, 65, '19mayis'),\n" +
                "                (721, 55, 70, 'Salıpazarı'),\n" +
                "                (722, 55, 75, 'Tekkeköy'),\n" +
                "                (723, 55, 80, 'Terme'),\n" +
                "                (724, 55, 85, 'Vezirköprü'),\n" +
                "                (725, 55, 90, 'Yakakent'),\n" +
                "                (726, 56, 0, 'Merkez'),\n" +
                "                (727, 56, 25, 'Aydınlar'),\n" +
                "                (728, 56, 30, 'Baykan'),\n" +
                "                (729, 56, 35, 'Eruh'),\n" +
                "                (730, 56, 42, 'Kozluk'),\n" +
                "                (731, 56, 45, 'Kurtalan'),\n" +
                "                (732, 56, 50, 'Pervari'),\n" +
                "                (733, 56, 55, 'Şirvan'),\n" +
                "                (734, 57, 0, 'Merkez'),\n" +
                "                (735, 57, 25, 'Ayancık'),\n" +
                "                (736, 57, 30, 'Boyabat'),\n" +
                "                (737, 57, 35, 'Dikmen'),\n" +
                "                (738, 57, 40, 'Durağan'),\n" +
                "                (739, 57, 45, 'Erfelek'),\n" +
                "                (740, 57, 50, 'Gerze'),\n" +
                "                (741, 57, 55, 'Saraydüzü'),\n" +
                "                (742, 57, 60, 'Türkeli'),\n" +
                "                (743, 58, 0, 'Merkez'),\n" +
                "                (744, 58, 24, 'Akıncılar'),\n" +
                "                (745, 58, 28, 'Altınyayla'),\n" +
                "                (746, 58, 32, 'Divriği'),\n" +
                "                (747, 58, 36, 'Doğansar'),\n" +
                "                (748, 58, 40, 'Gemerek'),\n" +
                "                (749, 58, 44, 'Gölova'),\n" +
                "                (750, 58, 48, 'Gürün'),\n" +
                "                (751, 58, 52, 'Hafik'),\n" +
                "                (752, 58, 56, 'Imranlı'),\n" +
                "                (753, 58, 60, 'Kangal'),\n" +
                "                (754, 58, 64, 'Koyulhisar'),\n" +
                "                (755, 58, 68, 'Susehri'),\n" +
                "                (756, 58, 72, 'Sarkışla'),\n" +
                "                (757, 58, 76, 'Ulas'),\n" +
                "                (758, 58, 80, 'Yildizeli'),\n" +
                "                (759, 58, 84, 'Zara'),\n" +
                "                (760, 59, 0, 'Merkez'),\n" +
                "                (761, 59, 25, 'Çerkezköy'),\n" +
                "                (762, 59, 30, 'Çorlu'),\n" +
                "                (763, 59, 35, 'Hayrabolu'),\n" +
                "                (764, 59, 40, 'Malkara'),\n" +
                "                (765, 59, 45, 'Marmaraeregli'),\n" +
                "                (766, 59, 50, 'Muratlı'),\n" +
                "                (767, 59, 55, 'Saray'),\n" +
                "                (768, 59, 60, 'Sarköy'),\n" +
                "                (769, 60, 0, 'Merkez'),\n" +
                "                (770, 60, 25, 'Almus'),\n" +
                "                (771, 60, 30, 'Artova'),\n" +
                "                (772, 60, 35, 'Basçiftlik'),\n" +
                "                (773, 60, 40, 'Erbaa'),\n" +
                "                (774, 60, 45, 'Niksar'),\n" +
                "                (775, 60, 50, 'Pazar'),\n" +
                "                (776, 60, 55, 'Resadiye'),\n" +
                "                (777, 60, 60, 'Sulusaray'),\n" +
                "                (778, 60, 65, 'Turhal'),\n" +
                "                (779, 60, 70, 'Yesilyurt'),\n" +
                "                (780, 60, 75, 'Zile'),\n" +
                "                (781, 61, 0, 'Merkez'),\n" +
                "                (782, 61, 24, 'Akçaabat'),\n" +
                "                (783, 61, 28, 'Araklı'),\n" +
                "                (784, 61, 32, 'Arsin'),\n" +
                "                (785, 61, 36, 'Besikdüzü'),\n" +
                "                (786, 61, 40, 'Çarsibaşı'),\n" +
                "                (787, 61, 44, 'Çaykara'),\n" +
                "                (788, 61, 48, 'Dernekpazar'),\n" +
                "                (789, 61, 52, 'Düzköy'),\n" +
                "                (790, 61, 56, 'Hayrat'),\n" +
                "                (791, 61, 60, 'Köprübaşı'),\n" +
                "                (792, 61, 64, 'Maçka'),\n" +
                "                (793, 61, 68, 'Of'),\n" +
                "                (794, 61, 72, 'Sürmene'),\n" +
                "                (795, 61, 76, 'Salpazarı'),\n" +
                "                (796, 61, 80, 'Tonya'),\n" +
                "                (797, 61, 84, 'Vakfikebir'),\n" +
                "                (798, 61, 88, 'Yomra'),\n" +
                "                (799, 62, 0, 'Merkez'),\n" +
                "                (800, 62, 25, 'Çemişgezek'),\n" +
                "                (801, 62, 30, 'Hozat'),\n" +
                "                (802, 62, 35, 'Mazgirt'),\n" +
                "                (803, 62, 40, 'Nazimiye'),\n" +
                "                (804, 62, 45, 'Ovacık'),\n" +
                "                (805, 62, 50, 'Pertek'),\n" +
                "                (806, 62, 55, 'Pülümür'),\n" +
                "                (807, 63, 0, 'Merkez'),\n" +
                "                (808, 63, 25, 'Akçakale'),\n" +
                "                (809, 63, 30, 'Birecik'),\n" +
                "                (810, 63, 35, 'Bozova'),\n" +
                "                (811, 63, 40, 'Ceylanpınar'),\n" +
                "                (812, 63, 45, 'Halfeti'),\n" +
                "                (813, 63, 50, 'Harran'),\n" +
                "                (814, 63, 55, 'Hilvan'),\n" +
                "                (815, 63, 60, 'Siverek'),\n" +
                "                (816, 63, 65, 'Suruç'),\n" +
                "                (817, 63, 70, 'Viransehir'),\n" +
                "                (818, 64, 0, 'Merkez'),\n" +
                "                (819, 64, 25, 'Banaz'),\n" +
                "                (820, 64, 30, 'Esme'),\n" +
                "                (821, 64, 35, 'Karahallı'),\n" +
                "                (822, 64, 40, 'Sivaslı'),\n" +
                "                (823, 64, 45, 'Ulubey'),\n" +
                "                (824, 65, 0, 'Merkez'),\n" +
                "                (825, 65, 25, 'Bahçesaray'),\n" +
                "                (826, 65, 30, 'Başkale'),\n" +
                "                (827, 65, 35, 'Çaldiran'),\n" +
                "                (828, 65, 40, 'Çatak'),\n" +
                "                (829, 65, 45, 'Edremit'),\n" +
                "                (830, 65, 50, 'Ercis'),\n" +
                "                (831, 65, 55, 'Gevas'),\n" +
                "                (832, 65, 60, 'Gürpınar'),\n" +
                "                (833, 65, 65, 'Muradiye'),\n" +
                "                (834, 65, 70, 'Özalp'),\n" +
                "                (835, 65, 75, 'Saray'),\n" +
                "                (836, 66, 0, 'Merkez'),\n" +
                "                (837, 66, 25, 'Akdağmadeni'),\n" +
                "                (838, 66, 30, 'Aydıncık'),\n" +
                "                (839, 66, 35, 'Bogazlıyan'),\n" +
                "                (840, 66, 40, 'Çandır'),\n" +
                "                (841, 66, 45, 'Çayıralan'),\n" +
                "                (842, 66, 50, 'Çekerek'),\n" +
                "                (843, 66, 55, 'Kadışehri'),\n" +
                "                (844, 66, 60, 'Sarıkaya'),\n" +
                "                (845, 66, 65, 'Saraykent'),\n" +
                "                (846, 66, 70, 'Sorgun'),\n" +
                "                (847, 66, 75, 'Sefaatli'),\n" +
                "                (848, 66, 80, 'Yenifakılı'),\n" +
                "                (849, 66, 85, 'Yerköy'),\n" +
                "                (850, 67, 0, 'Merkez'),\n" +
                "                (851, 67, 24, 'Alaplı'),\n" +
                "                (852, 67, 36, 'Çamoluk'),\n" +
                "                (853, 67, 38, 'Çaycuma'),\n" +
                "                (854, 67, 44, 'Devrek'),\n" +
                "                (855, 67, 52, 'Eflani'),\n" +
                "                (856, 67, 56, 'Eregli'),\n" +
                "                (857, 67, 60, 'Gökçebey'),\n" +
                "                (858, 68, 0, 'Merkez'),\n" +
                "                (859, 68, 25, 'Ağaçören'),\n" +
                "                (860, 68, 30, 'Eskil'),\n" +
                "                (861, 68, 35, 'Gülağaç'),\n" +
                "                (862, 68, 40, 'Güzelyurt'),\n" +
                "                (863, 68, 45, 'Ortaköy'),\n" +
                "                (864, 68, 50, 'Sarıyahşi'),\n" +
                "                (865, 69, 0, 'Merkez'),\n" +
                "                (866, 69, 25, 'Aydıntepe'),\n" +
                "                (867, 69, 30, 'Demirözü'),\n" +
                "                (868, 70, 0, 'Merkez'),\n" +
                "                (869, 70, 25, 'Ayrancı'),\n" +
                "                (870, 70, 30, 'Basyayla'),\n" +
                "                (871, 70, 35, 'Ermenek'),\n" +
                "                (872, 70, 40, 'Kazimkarabekir'),\n" +
                "                (873, 70, 45, 'Sarıveliler'),\n" +
                "                (874, 71, 0, 'Merkez'),\n" +
                "                (875, 71, 25, 'Bahsili'),\n" +
                "                (876, 71, 30, 'Bağlıseyh'),\n" +
                "                (877, 71, 35, 'Çelebi'),\n" +
                "                (878, 71, 40, 'Delice'),\n" +
                "                (879, 71, 45, 'Karakeçili'),\n" +
                "                (880, 71, 50, 'Keskin'),\n" +
                "                (881, 71, 55, 'Sulakyurt'),\n" +
                "                (882, 71, 60, 'Yahşihan'),\n" +
                "                (883, 72, 0, 'Merkez'),\n" +
                "                (884, 72, 25, 'Gercüs'),\n" +
                "                (885, 72, 30, 'Hasankeyf'),\n" +
                "                (886, 72, 35, 'Besiri'),\n" +
                "                (887, 72, 37, 'Kozluk'),\n" +
                "                (888, 72, 40, 'Sason'),\n" +
                "                (889, 73, 0, 'Merkez'),\n" +
                "                (890, 73, 25, 'Beytüsseba'),\n" +
                "                (891, 73, 30, 'Uludere'),\n" +
                "                (892, 73, 35, 'Cizre'),\n" +
                "                (893, 73, 40, 'İdil'),\n" +
                "                (894, 73, 45, 'Silopi'),\n" +
                "                (895, 73, 55, 'Güçlükonak'),\n" +
                "                (896, 74, 0, 'Merkez'),\n" +
                "                (897, 74, 20, 'Amasra'),\n" +
                "                (898, 74, 30, 'Kurucaşile'),\n" +
                "                (899, 74, 40, 'Ulus'),\n" +
                "                (900, 75, 0, 'Merkez'),\n" +
                "                (901, 75, 30, 'Çıldır'),\n" +
                "                (902, 75, 35, 'Damal'),\n" +
                "                (903, 75, 50, 'Göle'),\n" +
                "                (904, 75, 55, 'Hanak'),\n" +
                "                (905, 75, 75, 'Posof'),\n" +
                "                (906, 76, 0, 'Merkez'),\n" +
                "                (907, 76, 25, 'Aralık'),\n" +
                "                (908, 76, 50, 'Karakoyunlu'),\n" +
                "                (909, 76, 75, 'Tuzluca'),\n" +
                "                (910, 77, 0, 'Merkez'),\n" +
                "                (911, 77, 10, 'Altınova'),\n" +
                "                (912, 77, 15, 'Armutlu'),\n" +
                "                (913, 77, 20, 'Cınarcık'),\n" +
                "                (914, 77, 22, 'Ciftlikkoy'),\n" +
                "                (915, 77, 80, 'Termal'),\n" +
                "                (916, 78, 0, 'Merkez'),\n" +
                "                (917, 78, 30, 'Eflani'),\n" +
                "                (918, 78, 33, 'Eskipazar'),\n" +
                "                (919, 78, 50, 'Ovacık'),\n" +
                "                (920, 78, 70, 'Safranbolu'),\n" +
                "                (921, 78, 90, 'Yenice'),\n" +
                "                (922, 79, 0, 'Merkez'),\n" +
                "                (923, 79, 30, 'Elbeyli'),\n" +
                "                (924, 79, 50, 'Musabeyli'),\n" +
                "                (925, 79, 60, 'Polateli'),\n" +
                "                (926, 80, 0, 'Merkez'),\n" +
                "                (927, 80, 20, 'Bahçe'),\n" +
                "                (928, 80, 23, 'Hasanbeyli'),\n" +
                "                (929, 80, 25, 'Düziçi'),\n" +
                "                (930, 80, 30, 'Kadirli'),\n" +
                "                (931, 80, 45, 'Sunbas'),\n" +
                "                (932, 80, 50, 'Toprakkale'),\n" +
                "                (933, 81, 0, 'Merkez'),\n" +
                "                (934, 81, 20, 'Akçakoca'),\n" +
                "                (935, 81, 25, 'Cumayeri'),\n" +
                "                (936, 81, 30, 'Çilimli'),\n" +
                "                (937, 81, 35, 'Gölyaka'),\n" +
                "                (938, 81, 40, 'Gümüşova'),\n" +
                "                (939, 81, 45, 'Kaynaşlı'),\n" +
                "                (940, 81, 50, 'Yığılca'),\n" +
                "                (941, 3, 0, 'Sinanpaşa'),\n" +
                "                (942, 9, 0, 'Didim'),\n" +
                "                (943, 41, 0, 'Derince');";



        db.execSQL(iller_Create_Table);
        db.execSQL(Insert_Iller_SQL);
        db.execSQL(Create_Table_Ilceler);
        db.execSQL(Insert_Ilceler_Sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS ili");
        db.execSQL("DROP TABLE IF EXISTS ilcesi");

        // Create tables again
        onCreate(db);
    }

    /**
     * Database insert işlemini gerçekleştiren fonksiyon
     *
     * @param name
     * @param author
     * @param type
     * @param comment
     */
    public void insert(String name, String author,String type, String comment) {

	/*
			ContentValues cv=new ContentValues();
				cv.put("name", name);
				cv.put("author", author);
				cv.put("type", type);
				cv.put("comment", comment);
				getWritableDatabase().insert("books", "name", cv);*/
    }
    /**
     * Bütün listeyi dönüyor
     * @return
     */
    public List<String> getAllili(){
        List<String> iller = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM ili";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                iller.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning iller
        return iller;
    }

    public List<String> getAllilceler(long ilkodu){
        List<String> ilceler = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM ilcesi Where Ili=" + ilkodu;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ilceler.add(cursor.getString(3));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning ilceler
        return ilceler;
    }
}
