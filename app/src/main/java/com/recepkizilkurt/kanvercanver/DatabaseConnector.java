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
    private static final int SCHEMA_VERSION=3;

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
        String Insert_Ilceler_Sql ="INSERT INTO ilcesi VALUES"+
                "(1, 1, 0, 'Merkez'),"+
                "(2, 1, 20, 'Aladag'),"+
                "(3, 1, 28, 'Ceyhan'),"+
                "(4, 1, 36, 'Feke'),"+
                "(5, 1, 40, 'İmamoglu'),"+
                "(6, 1, 48, 'Karaisalı'),"+
                "(7, 1, 52, 'Karatas'),"+
                "(8, 1, 56, 'Kozan'),"+
                "(9, 1, 64, 'Pozantı'),"+
                "(10, 1, 68, 'Saimbeyli'),"+
                "(11, 1, 72, 'Seyhan'),"+
                "(12, 1, 76, 'Tufanbeyli'),"+
                "(13, 1, 80, 'Yumurtalik'),"+
                "(14, 1, 84, 'Yüregir'),"+
                "(15, 2, 0, 'Merkez'),"+
                "(16, 2, 20, 'Besni'),"+
                "(17, 2, 25, 'Çelikhan'),"+
                "(18, 2, 30, 'Gerger'),"+
                "(19, 2, 35, 'Gölbaşı'),"+
                "(20, 2, 40, 'Kahta'),"+
                "(21, 2, 45, 'Samsat'),"+
                "(22, 2, 50, 'Sincik'),"+
                "(23, 2, 55, 'Tut'),"+
                "(24, 3, 0, 'Merkez'),"+
                "(25, 3, 20, 'Basmakçı'),"+
                "(26, 3, 24, 'Bayat'),"+
                "(27, 3, 28, 'Bolvadin'),"+
                "(28, 3, 32, 'Çobanlar'),"+
                "(29, 3, 36, 'Çay'),"+
                "(30, 3, 40, 'Dazkırı'),"+
                "(31, 3, 44, 'Dinar'),"+
                "(32, 3, 48, 'Emirdag'),"+
                "(33, 3, 52, 'Evciler'),"+
                "(34, 3, 56, 'Hocalar'),"+
                "(35, 3, 60, 'İhsaniye'),"+
                "(36, 3, 64, 'İşcehisar'),"+
                "(37, 3, 68, 'Kızılören'),"+
                "(38, 3, 72, 'Sandiklı'),"+
                "(39, 3, 76, 'Sincanlı'),"+
                "(40, 3, 80, 'Sultandagi'),"+
                "(41, 3, 84, 'Suhut'),"+
                "(42, 4, 0, 'Merkez'),"+
                "(43, 4, 20, 'Diyadin'),"+
                "(44, 4, 25, 'Dogubeyazit'),"+
                "(45, 4, 30, 'Eleskirt'),"+
                "(46, 4, 35, 'Hamur'),"+
                "(47, 4, 40, 'Patnos'),"+
                "(48, 4, 45, 'Taşlıçay'),"+
                "(49, 4, 50, 'Tutak'),"+
                "(50, 5, 0, 'Merkez'),"+
                "(51, 5, 20, 'Göynücek'),"+
                "(52, 5, 25, 'Gümüshacıköy'),"+
                "(53, 5, 30, 'Hamamözü'),"+
                "(54, 5, 35, 'Merzifon'),"+
                "(55, 5, 40, 'Suluova'),"+
                "(56, 5, 45, 'Tasova'),"+
                "(57, 6, 0, 'Merkez'),"+
                "(58, 6, 20, 'Akyurt'),"+
                "(59, 6, 23, 'Altindag'),"+
                "(60, 6, 26, 'Ayas'),"+
                "(61, 6, 29, 'Bala'),"+
                "(62, 6, 32, 'Beypazari'),"+
                "(63, 6, 35, 'Çamlidere'),"+
                "(64, 6, 38, 'Çankaya'),"+
                "(65, 6, 41, 'Çubuk'),"+
                "(66, 6, 44, 'Elmadag'),"+
                "(67, 6, 47, 'Etimesgut'),"+
                "(68, 6, 50, 'Evren'),"+
                "(69, 6, 53, 'Gölbaşı'),"+
                "(70, 6, 56, 'Güdül'),"+
                "(71, 6, 59, 'Haymana'),"+
                "(72, 6, 62, 'Kalecik'),"+
                "(73, 6, 65, 'Kazan'),"+
                "(74, 6, 68, 'Keçiören'),"+
                "(75, 6, 71, 'Kızılcahamam'),"+
                "(76, 6, 74, 'Mamak'),"+
                "(77, 6, 77, 'Nallihan'),"+
                "(78, 6, 80, 'Polatli'),"+
                "(79, 6, 83, 'Sincan'),"+
                "(80, 6, 86, 'Sereflikoç'),"+
                "(81, 6, 89, 'Yenimahalle'),"+
                "(82, 7, 0, 'Merkez'),"+
                "(83, 7, 20, 'Akseki'),"+
                "(84, 7, 25, 'Alanya'),"+
                "(85, 7, 28, 'Demre'),"+
                "(86, 7, 30, 'Elmali'),"+
                "(87, 7, 35, 'Finike'),"+
                "(88, 7, 40, 'Gazipaşa'),"+
                "(89, 7, 45, 'Gündogmus'),"+
                "(90, 7, 50, 'İbradi'),"+
                "(91, 7, 55, 'Kale'),"+
                "(92, 7, 60, 'Kas'),"+
                "(93, 7, 65, 'Kemer'),"+
                "(94, 7, 70, 'Korkuteli'),"+
                "(95, 7, 75, 'Kumluca'),"+
                "(96, 7, 80, 'Manavgat'),"+
                "(97, 7, 85, 'Serik'),"+
                "(98, 8, 0, 'Merkez'),"+
                "(99, 8, 20, 'Ardanuç'),"+
                "(100, 8, 25, 'Arhavi'),"+
                "(101, 8, 30, 'Borçka'),"+
                "(102, 8, 32, 'Hopa'),"+
                "(103, 8, 35, 'Murgul'),"+
                "(104, 8, 45, 'Savsat'),"+
                "(105, 8, 50, 'Yusufeli'),"+
                "(106, 9, 0, 'Merkez'),"+
                "(107, 9, 20, 'Bozdogan'),"+
                "(108, 9, 24, 'Buharkent'),"+
                "(109, 9, 28, 'Çine'),"+
                "(110, 9, 32, 'Germencık'),"+
                "(111, 9, 36, 'Incirliova'),"+
                "(112, 9, 40, 'Karacasu'),"+
                "(113, 9, 44, 'Karpuzlu'),"+
                "(114, 9, 48, 'Koçarli'),"+
                "(115, 9, 52, 'Kösk'),"+
                "(116, 9, 56, 'Kusadasi'),"+
                "(117, 9, 60, 'Kuyucak'),"+
                "(118, 9, 64, 'Nazilli'),"+
                "(119, 9, 68, 'Söke'),"+
                "(120, 9, 72, 'Sultanhisar'),"+
                "(121, 9, 76, 'Yenihisar'),"+
                "(122, 9, 80, 'Yenipazar'),"+
                "(123, 10, 0, 'Merkez'),"+
                "(124, 10, 20, 'Ayvalik'),"+
                "(125, 10, 21, 'Akçay'),"+
                "(126, 10, 24, 'Balya'),"+
                "(127, 10, 28, 'Bandirma'),"+
                "(128, 10, 32, 'Bigadiç'),"+
                "(129, 10, 36, 'Burhaniye'),"+
                "(130, 10, 40, 'Dursunbey'),"+
                "(131, 10, 44, 'Edremit'),"+
                "(132, 10, 48, 'Erdek'),"+
                "(133, 10, 52, 'Gönen'),"+
                "(134, 10, 56, 'Gömeç'),"+
                "(135, 10, 60, 'Havran'),"+
                "(136, 10, 64, 'İvrindi'),"+
                "(137, 10, 68, 'Kepsut'),"+
                "(138, 10, 72, 'Manyas'),"+
                "(139, 10, 76, 'Marmara'),"+
                "(140, 10, 80, 'Savastepe'),"+
                "(141, 10, 84, 'Sındırgı'),"+
                "(142, 10, 88, 'Susurluk'),"+
                "(143, 11, 0, 'Merkez'),"+
                "(144, 11, 20, 'Bozöyük'),"+
                "(145, 11, 25, 'Gölpazari'),"+
                "(146, 11, 30, 'Inhisar'),"+
                "(147, 11, 35, 'Osmaneli'),"+
                "(148, 11, 40, 'Pazaryeri'),"+
                "(149, 11, 45, 'Sögüt'),"+
                "(150, 11, 50, 'Yenipazar'),"+
                "(151, 12, 0, 'Merkez'),"+
                "(152, 12, 20, 'Adaklı'),"+
                "(153, 12, 25, 'Genç'),"+
                "(154, 12, 30, 'Karliova'),"+
                "(155, 12, 35, 'Kigi'),"+
                "(156, 12, 40, 'Solhan'),"+
                "(157, 12, 45, 'Yayladere'),"+
                "(158, 12, 55, 'Yedisu'),"+
                "(159, 13, 0, 'Merkez'),"+
                "(160, 13, 20, 'Adilcevaz'),"+
                "(161, 13, 25, 'Ahlat'),"+
                "(162, 13, 30, 'Güroymak'),"+
                "(163, 13, 35, 'Hizan'),"+
                "(164, 13, 40, 'Mutki'),"+
                "(165, 13, 45, 'Tatvan'),"+
                "(166, 14, 0, 'Merkez'),"+
                "(167, 14, 35, 'Dörtdivan'),"+
                "(168, 14, 45, 'Gerede'),"+
                "(169, 14, 55, 'Göynük'),"+
                "(170, 14, 60, 'Kibriscık'),"+
                "(171, 14, 65, 'Mengen'),"+
                "(172, 14, 70, 'Mudurnu'),"+
                "(173, 14, 75, 'Seben'),"+
                "(174, 14, 80, 'Yeniçaga'),"+
                "(175, 15, 0, 'Merkez'),"+
                "(176, 15, 20, 'Altinyayla'),"+
                "(177, 15, 25, 'Aglasun'),"+
                "(178, 15, 30, 'Bucak'),"+
                "(179, 15, 35, 'Çavdir'),"+
                "(180, 15, 40, 'Çeltikçi'),"+
                "(181, 15, 45, 'Gölhisar'),"+
                "(182, 15, 50, 'Karamanlı'),"+
                "(183, 15, 55, 'Kemer'),"+
                "(184, 15, 60, 'Tefenni'),"+
                "(185, 15, 65, 'Yesilova'),"+
                "(186, 16, 0, 'Merkez'),"+
                "(187, 16, 24, 'Büyükorhan'),"+
                "(188, 16, 28, 'Gemlik'),"+
                "(189, 16, 32, 'Gürsu'),"+
                "(190, 16, 36, 'Harmancık'),"+
                "(191, 16, 40, 'İnegöl'),"+
                "(192, 16, 44, 'İznik'),"+
                "(193, 16, 48, 'Karacabey'),"+
                "(194, 16, 52, 'Keles'),"+
                "(195, 16, 56, 'Kestel'),"+
                "(196, 16, 60, 'Mudanya'),"+
                "(197, 16, 64, 'Mustafakema'),"+
                "(198, 16, 68, 'Nilüfer'),"+
                "(199, 16, 72, 'Orhaneli'),"+
                "(200, 16, 76, 'Orhangazi'),"+
                "(201, 16, 80, 'Osmangazi'),"+
                "(202, 16, 84, 'Yenisehir'),"+
                "(203, 16, 88, 'Yıldırım'),"+
                "(204, 17, 0, 'Merkez'),"+
                "(205, 17, 25, 'Ayvacık'),"+
                "(206, 17, 30, 'Bayramiç'),"+
                "(207, 17, 32, 'Bozcaada'),"+
                "(208, 17, 35, 'Biga'),"+
                "(209, 17, 40, 'Çan'),"+
                "(210, 17, 45, 'Eceabat'),"+
                "(211, 17, 50, 'Ezine'),"+
                "(212, 17, 55, 'Gelibolu'),"+
                "(213, 17, 57, 'Gökçeada'),"+
                "(214, 17, 65, 'Lapseki'),"+
                "(215, 17, 70, 'Yenice'),"+
                "(216, 18, 0, 'Merkez'),"+
                "(217, 18, 25, 'Atkaracalar'),"+
                "(218, 18, 30, 'Bayramören'),"+
                "(219, 18, 35, 'Çerkes'),"+
                "(220, 18, 40, 'Eldivan'),"+
                "(221, 18, 50, 'Ilgaz'),"+
                "(222, 18, 55, 'Kızılkırmak'),"+
                "(223, 18, 60, 'Korgun'),"+
                "(224, 18, 65, 'Kurşunlu'),"+
                "(225, 18, 70, 'Orta'),"+
                "(226, 18, 75, 'Ovacık'),"+
                "(227, 18, 80, 'Sabanözü'),"+
                "(228, 18, 85, 'Yapraklı'),"+
                "(229, 19, 0, 'Merkez'),"+
                "(230, 19, 25, 'Alaca'),"+
                "(231, 19, 30, 'Bayat'),"+
                "(232, 19, 35, 'Bogazkale'),"+
                "(233, 19, 40, 'Dodurga'),"+
                "(234, 19, 45, 'İskilip'),"+
                "(235, 19, 50, 'Kargı'),"+
                "(236, 19, 55, 'Laçin'),"+
                "(237, 19, 60, 'Mecitözü'),"+
                "(238, 19, 65, 'Oguzlar'),"+
                "(239, 19, 70, 'Ortaköy'),"+
                "(240, 19, 75, 'Osmancık'),"+
                "(241, 19, 80, 'Sungurlu'),"+
                "(242, 19, 85, 'Ugurludag'),"+
                "(243, 20, 0, 'Merkez'),"+
                "(244, 20, 23, 'Acipayam'),"+
                "(245, 20, 26, 'Akköy'),"+
                "(246, 20, 29, 'Babadag'),"+
                "(247, 20, 32, 'Baklan'),"+
                "(248, 20, 35, 'Bekilli'),"+
                "(249, 20, 38, 'Beyagaç'),"+
                "(250, 20, 41, 'Buldan'),"+
                "(251, 20, 44, 'Bozkurt'),"+
                "(252, 20, 47, 'Çal'),"+
                "(253, 20, 50, 'Çameli'),"+
                "(254, 20, 53, 'Çardak'),"+
                "(255, 20, 56, 'Çivril'),"+
                "(256, 20, 59, 'Güney'),"+
                "(257, 20, 62, 'Honaz'),"+
                "(258, 20, 65, 'Kale'),"+
                "(259, 20, 68, 'Sarayköy'),"+
                "(260, 20, 71, 'Serinhisar'),"+
                "(261, 20, 74, 'Tavas'),"+
                "(262, 21, 0, 'Merkez'),"+
                "(263, 21, 25, 'Bismil'),"+
                "(264, 21, 30, 'Çermik'),"+
                "(265, 21, 35, 'Çinar'),"+
                "(266, 21, 40, 'Çüngüs'),"+
                "(267, 21, 45, 'Dicle'),"+
                "(268, 21, 50, 'Egil'),"+
                "(269, 21, 55, 'Ergani'),"+
                "(270, 21, 60, 'Hani'),"+
                "(271, 21, 65, 'Hazro'),"+
                "(272, 21, 70, 'Kocaköy'),"+
                "(273, 21, 75, 'Kulp'),"+
                "(274, 21, 80, 'Lice'),"+
                "(275, 21, 85, 'Silvan'),"+
                "(276, 22, 0, 'Merkez'),"+
                "(277, 22, 25, 'Enez'),"+
                "(278, 22, 30, 'Havsa'),"+
                "(279, 22, 35, 'Ipsala'),"+
                "(280, 22, 40, 'Kesan'),"+
                "(281, 22, 45, 'Lalapaşa'),"+
                "(282, 22, 50, 'Meriç'),"+
                "(283, 22, 55, 'Süloglu'),"+
                "(284, 22, 60, 'Uzunköprü'),"+
                "(285, 23, 0, 'Merkez'),"+
                "(286, 23, 25, 'Agin'),"+
                "(287, 23, 30, 'Alacakaya'),"+
                "(288, 23, 35, 'Aricak'),"+
                "(289, 23, 40, 'Baskil'),"+
                "(290, 23, 45, 'Karakoçan'),"+
                "(291, 23, 50, 'Keban'),"+
                "(292, 23, 55, 'Kovancilar'),"+
                "(293, 23, 60, 'Maden'),"+
                "(294, 23, 65, 'Palu'),"+
                "(295, 23, 70, 'Sivrice'),"+
                "(296, 24, 0, 'Merkez'),"+
                "(297, 24, 25, 'Çayirli'),"+
                "(298, 24, 30, 'Iliç'),"+
                "(299, 24, 35, 'Kemah'),"+
                "(300, 24, 40, 'Kemaliye'),"+
                "(301, 24, 45, 'Otlukbeli'),"+
                "(302, 24, 50, 'Refahiye'),"+
                "(303, 24, 55, 'Tercan'),"+
                "(304, 24, 60, 'Üzümlü'),"+
                "(305, 25, 0, 'Merkez'),"+
                "(306, 25, 23, 'Askale'),"+
                "(307, 25, 26, 'Çat'),"+
                "(308, 25, 29, 'Hinis'),"+
                "(309, 25, 32, 'Horasan'),"+
                "(310, 25, 35, 'Ilica'),"+
                "(311, 25, 38, 'Ispir'),"+
                "(312, 25, 41, 'Karaçoban'),"+
                "(313, 25, 44, 'Karayazi'),"+
                "(314, 25, 47, 'Köprüköy'),"+
                "(315, 25, 50, 'Narman'),"+
                "(316, 25, 53, 'Oltu'),"+
                "(317, 25, 55, 'Olur'),"+
                "(318, 25, 58, 'Pasinler'),"+
                "(319, 25, 61, 'Pazaryolu'),"+
                "(320, 25, 64, 'Senkaya'),"+
                "(321, 25, 67, 'Tekman'),"+
                "(322, 25, 70, 'Tortum'),"+
                "(323, 25, 73, 'Uzundere'),"+
                "(324, 26, 0, 'Merkez'),"+
                "(325, 26, 25, 'Alpu'),"+
                "(326, 26, 30, 'Beylikova'),"+
                "(327, 26, 35, 'Çifteler'),"+
                "(328, 26, 40, 'Günyüzü'),"+
                "(329, 26, 45, 'Han'),"+
                "(330, 26, 50, 'Inönü'),"+
                "(331, 26, 55, 'Mahmudiye'),"+
                "(332, 26, 60, 'Mihalgazi'),"+
                "(333, 26, 65, 'Mihaliççik'),"+
                "(334, 26, 70, 'Saricakaya'),"+
                "(335, 26, 75, 'Seyitgazi'),"+
                "(336, 26, 80, 'Sivrihisar'),"+
                "(337, 27, 0, 'Merkez'),"+
                "(338, 27, 25, 'Araban'),"+
                "(339, 27, 30, 'Islahiye'),"+
                "(340, 27, 35, 'Kilis'),"+
                "(341, 27, 40, 'Kargamis'),"+
                "(342, 27, 45, 'Nizip'),"+
                "(343, 27, 50, 'Nurdagi'),"+
                "(344, 27, 55, 'Oguzeli'),"+
                "(345, 27, 60, 'Sahinbey'),"+
                "(346, 27, 65, 'Sehitkamil'),"+
                "(347, 27, 70, 'Yavuzeli'),"+
                "(348, 28, 0, 'Merkez'),"+
                "(349, 28, 25, 'Alucra'),"+
                "(350, 28, 30, 'Bulancak'),"+
                "(351, 28, 32, 'Çamoluk'),"+
                "(352, 28, 35, 'Çanakçi'),"+
                "(353, 28, 40, 'Dereli'),"+
                "(354, 28, 42, 'Dogankent'),"+
                "(355, 28, 45, 'Espiye'),"+
                "(356, 28, 50, 'Eynesil'),"+
                "(357, 28, 55, 'Görele'),"+
                "(358, 28, 60, 'Güce'),"+
                "(359, 28, 65, 'Kesap'),"+
                "(360, 28, 70, 'Piraziz'),"+
                "(361, 28, 75, 'Sebinkarahisar'),"+
                "(362, 28, 80, 'Tirebolu'),"+
                "(363, 28, 85, 'Yaglidere'),"+
                "(364, 29, 0, 'Merkez'),"+
                "(365, 29, 25, 'Kelkit'),"+
                "(366, 29, 30, 'Köse'),"+
                "(367, 29, 35, 'Kürtün'),"+
                "(368, 29, 40, 'Siran'),"+
                "(369, 29, 45, 'Torul'),"+
                "(370, 30, 0, 'Merkez'),"+
                "(371, 30, 25, 'Çukurca'),"+
                "(372, 30, 30, 'Semdinli'),"+
                "(373, 30, 35, 'Yüksekova'),"+
                "(374, 31, 0, 'Merkez'),"+
                "(375, 31, 25, 'Altinözü'),"+
                "(376, 31, 30, 'Belen'),"+
                "(377, 31, 35, 'Dörtyol'),"+
                "(378, 31, 40, 'Erzin'),"+
                "(379, 31, 45, 'Hassa'),"+
                "(380, 31, 50, 'Iskenderun'),"+
                "(381, 31, 55, 'Kirikhan'),"+
                "(382, 31, 60, 'Kumlu'),"+
                "(383, 31, 65, 'Reyhanlı'),"+
                "(384, 31, 70, 'Samandagi'),"+
                "(385, 31, 75, 'Yayladagi'),"+
                "(386, 32, 0, 'Merkez'),"+
                "(387, 32, 25, 'Aksu'),"+
                "(388, 32, 30, 'Atabey'),"+
                "(389, 32, 35, 'Egirdir'),"+
                "(390, 32, 40, 'Gelendost'),"+
                "(391, 32, 45, 'Gönen'),"+
                "(392, 32, 50, 'Keçiborlu'),"+
                "(393, 32, 55, 'Senirkent'),"+
                "(394, 32, 60, 'Sütçüler'),"+
                "(395, 32, 65, 'Sarkikaraag'),"+
                "(396, 32, 70, 'Uluborlu'),"+
                "(397, 32, 75, 'Yenisarbade'),"+
                "(398, 32, 80, 'Yalvaç'),"+
                "(399, 33, 0, 'Merkez'),"+
                "(400, 33, 25, 'Anamur'),"+
                "(401, 33, 30, 'Aydincık'),"+
                "(402, 33, 35, 'Bozyazi'),"+
                "(403, 33, 40, 'Çamliyayla'),"+
                "(404, 33, 45, 'Erdemli'),"+
                "(405, 33, 50, 'Gülnar'),"+
                "(406, 33, 55, 'Mut'),"+
                "(407, 33, 60, 'Silifke'),"+
                "(408, 33, 65, 'Tarsus'),"+
                "(409, 34, 0, 'Merkez'),"+
                "(410, 34, 23, 'Adalar'),"+
                "(411, 34, 24, 'Avcilar'),"+
                "(412, 34, 25, 'Bagcilar'),"+
                "(413, 34, 26, 'Bakirköy'),"+
                "(414, 34, 27, 'Bahçelievle'),"+
                "(415, 34, 29, 'Bayrampaşa'),"+
                "(416, 34, 32, 'Besiktas'),"+
                "(417, 34, 35, 'Beykoz'),"+
                "(418, 34, 38, 'Beyoglu'),"+
                "(419, 34, 41, 'Büyükçekmece'),"+
                "(420, 34, 44, 'Çatalca'),"+
                "(421, 34, 47, 'Eminönü'),"+
                "(422, 34, 50, 'Eyüp'),"+
                "(423, 34, 51, 'Esenler'),"+
                "(424, 34, 53, 'Fatih'),"+
                "(425, 34, 56, 'Gaziosmanpaşa'),"+
                "(426, 34, 57, 'Güngören'),"+
                "(427, 34, 59, 'Kadiköy'),"+
                "(428, 34, 61, 'Kagithane'),"+
                "(429, 34, 64, 'Kartal'),"+
                "(430, 34, 67, 'Küçükçekmece'),"+
                "(431, 34, 68, 'Maltepe'),"+
                "(432, 34, 70, 'Pendik'),"+
                "(433, 34, 73, 'Sariyer'),"+
                "(434, 34, 76, 'Silivri'),"+
                "(435, 34, 77, 'Sultanbeyli'),"+
                "(436, 34, 79, 'Sile'),"+
                "(437, 34, 81, 'Sisli'),"+
                "(438, 34, 82, 'Tuzla'),"+
                "(439, 34, 84, 'Ümraniye'),"+
                "(440, 34, 87, 'Üsküdar'),"+
                "(441, 34, 90, 'Yalova'),"+
                "(442, 34, 93, 'Zeytinburnu'),"+
                "(443, 35, 0, 'Merkez'),"+
                "(444, 35, 23, 'Aliaga'),"+
                "(445, 35, 26, 'Bayindir'),"+
                "(446, 35, 27, 'Balçova'),"+
                "(447, 35, 29, 'Bergama'),"+
                "(448, 35, 32, 'Beydag'),"+
                "(449, 35, 35, 'Bornova'),"+
                "(450, 35, 37, 'Buca'),"+
                "(451, 35, 41, 'Çesme'),"+
                "(452, 35, 42, 'Çiğli'),"+
                "(453, 35, 44, 'Dikili'),"+
                "(454, 35, 47, 'Foça'),"+
                "(455, 35, 48, 'Gaziemir'),"+
                "(456, 35, 49, 'Güzelbahçe'),"+
                "(457, 35, 50, 'Karaburun'),"+
                "(458, 35, 53, 'Karsiyaka'),"+
                "(459, 35, 56, 'Kemalpaşa'),"+
                "(460, 35, 59, 'Kinik'),"+
                "(461, 35, 62, 'Kiraz'),"+
                "(462, 35, 65, 'Konak'),"+
                "(463, 35, 68, 'Menderes'),"+
                "(464, 35, 71, 'Menemen'),"+
                "(465, 35, 72, 'Narlidere'),"+
                "(466, 35, 74, 'Ödemis'),"+
                "(467, 35, 77, 'Seferihisar'),"+
                "(468, 35, 80, 'Selçuk'),"+
                "(469, 35, 83, 'Tire'),"+
                "(470, 35, 86, 'Torbali'),"+
                "(471, 35, 89, 'Urla'),"+
                "(472, 36, 0, 'Merkez'),"+
                "(473, 36, 24, 'Akyaka'),"+
                "(474, 36, 36, 'Arpaçay'),"+
                "(475, 36, 44, 'Digor'),"+
                "(476, 36, 60, 'Kağizman'),"+
                "(477, 36, 68, 'Sarikamis'),"+
                "(478, 36, 72, 'Selim'),"+
                "(479, 36, 76, 'Susuz'),"+
                "(480, 37, 0, 'Merkez'),"+
                "(481, 37, 23, 'Abana'),"+
                "(482, 37, 26, 'Agli'),"+
                "(483, 37, 29, 'Araç'),"+
                "(484, 37, 32, 'Azdavay'),"+
                "(485, 37, 35, 'Bozkurt'),"+
                "(486, 37, 38, 'Cide'),"+
                "(487, 37, 41, 'Çatalzeytin'),"+
                "(488, 37, 44, 'Daday'),"+
                "(489, 37, 47, 'Devrekani'),"+
                "(490, 37, 50, 'Doganyurt'),"+
                "(491, 37, 53, 'Hanönü'),"+
                "(492, 37, 56, 'Ihsangazi'),"+
                "(493, 37, 59, 'Inebolu'),"+
                "(494, 37, 62, 'Küre'),"+
                "(495, 37, 65, 'Pinarbaşı'),"+
                "(496, 37, 68, 'Seydiler'),"+
                "(497, 37, 71, 'Senpazar'),"+
                "(498, 37, 74, 'Taşköprü'),"+
                "(499, 37, 77, 'Tosya'),"+
                "(500, 38, 0, 'Merkez'),"+
                "(501, 38, 24, 'Akkışla'),"+
                "(502, 38, 28, 'Bünyan'),"+
                "(503, 38, 32, 'Develi'),"+
                "(504, 38, 36, 'Felahiye'),"+
                "(505, 38, 40, 'Hacilar'),"+
                "(506, 38, 44, 'Incesu'),"+
                "(507, 38, 48, 'Kocasinan'),"+
                "(508, 38, 52, 'Melikgazi'),"+
                "(509, 38, 56, 'Özvatan'),"+
                "(510, 38, 60, 'Pinarbaşı'),"+
                "(511, 38, 64, 'Sarioglan'),"+
                "(512, 38, 68, 'Sariz'),"+
                "(513, 38, 72, 'Talas'),"+
                "(514, 38, 76, 'Tomarza'),"+
                "(515, 38, 80, 'Yahyali'),"+
                "(516, 38, 84, 'Yesilhisar'),"+
                "(517, 39, 0, 'Merkez'),"+
                "(518, 39, 25, 'Babaeski'),"+
                "(519, 39, 30, 'Demirköy'),"+
                "(520, 39, 35, 'Kofçaz'),"+
                "(521, 39, 40, 'Lüleburgaz'),"+
                "(522, 39, 45, 'Pehlivanköy'),"+
                "(523, 39, 50, 'Pinarhisar'),"+
                "(524, 39, 55, 'Vize'),"+
                "(525, 40, 0, 'Merkez'),"+
                "(526, 40, 20, 'Akçakent'),"+
                "(527, 40, 25, 'Akpinar'),"+
                "(528, 40, 27, 'Boztepe'),"+
                "(529, 40, 30, 'Çiçekdagi'),"+
                "(530, 40, 35, 'Kaman'),"+
                "(531, 40, 40, 'Mucur'),"+
                "(532, 41, 0, 'Merkez'),"+
                "(533, 41, 20, 'Darica'),"+
                "(534, 41, 25, 'Gebze'),"+
                "(535, 41, 30, 'Gölcük'),"+
                "(536, 41, 35, 'Kandira'),"+
                "(537, 41, 40, 'Karamürsel'),"+
                "(538, 41, 45, 'Körfez'),"+
                "(539, 42, 0, 'Merkez'),"+
                "(540, 42, 22, 'Ahirli'),"+
                "(541, 42, 24, 'Akören'),"+
                "(542, 42, 26, 'Aksehir'),"+
                "(543, 42, 28, 'Altinekin'),"+
                "(544, 42, 30, 'Beysehir'),"+
                "(545, 42, 32, 'Bozkir'),"+
                "(546, 42, 34, 'Derebucak'),"+
                "(547, 42, 36, 'Cihanbeyli'),"+
                "(548, 42, 38, 'Çumra'),"+
                "(549, 42, 40, 'Çeltik'),"+
                "(550, 42, 42, 'Derbent'),"+
                "(551, 42, 44, 'Doganhisar'),"+
                "(552, 42, 46, 'Emirgazi'),"+
                "(553, 42, 48, 'Eregli'),"+
                "(554, 42, 50, 'Güneysinir'),"+
                "(555, 42, 52, 'Halkapinar'),"+
                "(556, 42, 54, 'Hadim'),"+
                "(557, 42, 55, 'Halkapinar'),"+
                "(558, 42, 56, 'Hüyük'),"+
                "(559, 42, 58, 'Ilgin'),"+
                "(560, 42, 60, 'Kadinhani'),"+
                "(561, 42, 62, 'Karapinar'),"+
                "(562, 42, 64, 'Karatay'),"+
                "(563, 42, 66, 'Kulu'),"+
                "(564, 42, 68, 'Meram'),"+
                "(565, 42, 70, 'Sarayönü'),"+
                "(566, 42, 72, 'Selçuklu'),"+
                "(567, 42, 74, 'Seydisehir'),"+
                "(568, 42, 76, 'Taskent'),"+
                "(569, 42, 78, 'Tuzlukçu'),"+
                "(570, 42, 80, 'Yalihöyük'),"+
                "(571, 42, 82, 'Yunak'),"+
                "(572, 43, 0, 'Merkez'),"+
                "(573, 43, 25, 'Altintas'),"+
                "(574, 43, 30, 'Aslanapa'),"+
                "(575, 43, 35, 'Cavdarhisar'),"+
                "(576, 43, 40, 'Domaniç'),"+
                "(577, 43, 45, 'Dumlupinar'),"+
                "(578, 43, 50, 'Emet'),"+
                "(579, 43, 55, 'Gediz'),"+
                "(580, 43, 60, 'Hisarcık'),"+
                "(581, 43, 65, 'Pazarlar'),"+
                "(582, 43, 70, 'Simav'),"+
                "(583, 43, 75, 'Saphane'),"+
                "(584, 43, 80, 'Tavsanlı'),"+
                "(585, 44, 0, 'Merkez'),"+
                "(586, 44, 25, 'Akçadag'),"+
                "(587, 44, 30, 'Arapgir'),"+
                "(588, 44, 35, 'Arguvan'),"+
                "(589, 44, 40, 'Battalgazi'),"+
                "(590, 44, 45, 'Darende'),"+
                "(591, 44, 50, 'Dogansehir'),"+
                "(592, 44, 55, 'Doganyol'),"+
                "(593, 44, 60, 'Hekimhan'),"+
                "(594, 44, 65, 'Kale'),"+
                "(595, 44, 70, 'Kuluncak'),"+
                "(596, 44, 75, 'Pötürge'),"+
                "(597, 44, 80, 'Yazihan'),"+
                "(598, 44, 85, 'Yesilyurt'),"+
                "(599, 45, 0, 'Merkez'),"+
                "(600, 45, 25, 'Ahmetli'),"+
                "(601, 45, 30, 'Akhisar'),"+
                "(602, 45, 35, 'Alasehir'),"+
                "(603, 45, 40, 'Demirci'),"+
                "(604, 45, 45, 'Gölmarmara'),"+
                "(605, 45, 50, 'Gördes'),"+
                "(606, 45, 55, 'Kirkagaç'),"+
                "(607, 45, 60, 'Köprübaşı'),"+
                "(608, 45, 65, 'Kula'),"+
                "(609, 45, 70, 'Salihli'),"+
                "(610, 45, 75, 'Sarıgöl'),"+
                "(611, 45, 80, 'Saruhanlı'),"+
                "(612, 45, 85, 'Selendi'),"+
                "(613, 45, 90, 'Soma'),"+
                "(614, 45, 95, 'Turgutlu'),"+
                "(615, 46, 0, 'Merkez'),"+
                "(616, 46, 25, 'Afsin'),"+
                "(617, 46, 30, 'Andirin'),"+
                "(618, 46, 35, 'Çaglayancer'),"+
                "(619, 46, 40, 'Ekinözü'),"+
                "(620, 46, 45, 'Elbistan'),"+
                "(621, 46, 50, 'Göksun'),"+
                "(622, 46, 55, 'Nurhak'),"+
                "(623, 46, 60, 'Pazarcık'),"+
                "(624, 46, 65, 'Türkoglu'),"+
                "(625, 47, 0, 'Merkez'),"+
                "(626, 47, 25, 'Dargeçit'),"+
                "(627, 47, 30, 'Derik'),"+
                "(628, 47, 40, 'Kızıltepe'),"+
                "(629, 47, 45, 'Mazidagi'),"+
                "(630, 47, 50, 'Midyat'),"+
                "(631, 47, 55, 'Nusaybin'),"+
                "(632, 47, 60, 'Ömerli'),"+
                "(633, 47, 65, 'Savur'),"+
                "(634, 47, 70, 'Yesilli'),"+
                "(635, 48, 0, 'Merkez'),"+
                "(636, 48, 25, 'Bodrum'),"+
                "(637, 48, 30, 'Dalaman'),"+
                "(638, 48, 35, 'Datça'),"+
                "(639, 48, 40, 'Fethiye'),"+
                "(640, 48, 45, 'Kavaklıdere'),"+
                "(641, 48, 50, 'Köycegiz'),"+
                "(642, 48, 55, 'Marmaris'),"+
                "(643, 48, 60, 'Milas'),"+
                "(644, 48, 65, 'Ortaca'),"+
                "(645, 48, 70, 'Ula'),"+
                "(646, 48, 75, 'Yatagan'),"+
                "(647, 49, 0, 'Merkez'),"+
                "(648, 49, 25, 'Bulanik'),"+
                "(649, 49, 30, 'Hasköy'),"+
                "(650, 49, 35, 'Korkut'),"+
                "(651, 49, 40, 'Malazgirt'),"+
                "(652, 49, 45, 'Varto'),"+
                "(653, 50, 0, 'Merkez'),"+
                "(654, 50, 25, 'Acigöl'),"+
                "(655, 50, 30, 'Avanos'),"+
                "(656, 50, 35, 'Derinkuyu'),"+
                "(657, 50, 40, 'Gülsehir'),"+
                "(658, 50, 45, 'Hacibektas'),"+
                "(659, 50, 50, 'Kozaklı'),"+
                "(660, 50, 55, 'Ürgüp'),"+
                "(661, 51, 0, 'Merkez'),"+
                "(662, 51, 25, 'Altunhisar'),"+
                "(663, 51, 30, 'Bor'),"+
                "(664, 51, 35, 'Çamardi'),"+
                "(665, 51, 40, 'Çiftlik'),"+
                "(666, 51, 45, 'Ulukışla'),"+
                "(667, 52, 0, 'Merkez'),"+
                "(668, 52, 23, 'Akkus'),"+
                "(669, 52, 26, 'Aybasti'),"+
                "(670, 52, 29, 'Çamas'),"+
                "(671, 52, 32, 'Çatalpinar'),"+
                "(672, 52, 35, 'Çaybaşı'),"+
                "(673, 52, 38, 'Fatsa'),"+
                "(674, 52, 41, 'Gölköy'),"+
                "(675, 52, 44, 'Gölyali'),"+
                "(676, 52, 47, 'Gürgentepe'),"+
                "(677, 52, 50, 'İkizce'),"+
                "(678, 52, 53, 'Korgan'),"+
                "(679, 52, 56, 'Kabadüz'),"+
                "(680, 52, 59, 'Kabatas'),"+
                "(681, 52, 62, 'Kumru'),"+
                "(682, 52, 65, 'Mesudiye'),"+
                "(683, 52, 68, 'Persembe'),"+
                "(684, 52, 71, 'Ulubey'),"+
                "(685, 52, 74, 'Ünye'),"+
                "(686, 53, 0, 'Merkez'),"+
                "(687, 53, 25, 'Ardesen'),"+
                "(688, 53, 30, 'Çamlihemsin'),"+
                "(689, 53, 35, 'Çayeli'),"+
                "(690, 53, 40, 'Derepazarı'),"+
                "(691, 53, 45, 'Fındıklı'),"+
                "(692, 53, 50, 'Güneysu'),"+
                "(693, 53, 55, 'Hemsin'),"+
                "(694, 53, 60, 'İkizdere'),"+
                "(695, 53, 65, 'İyidere'),"+
                "(696, 53, 70, 'Kalkandere'),"+
                "(697, 53, 75, 'Pazar'),"+
                "(698, 54, 0, 'Merkez'),"+
                "(699, 54, 25, 'Akyazi'),"+
                "(700, 54, 30, 'Ferizli'),"+
                "(701, 54, 35, 'Geyve'),"+
                "(702, 54, 40, 'Hendek'),"+
                "(703, 54, 45, 'Karapürçek'),"+
                "(704, 54, 50, 'Karasu'),"+
                "(705, 54, 55, 'Kaynarca'),"+
                "(706, 54, 60, 'Kocaali'),"+
                "(707, 54, 65, 'Pamukova'),"+
                "(708, 54, 70, 'Sapanca'),"+
                "(709, 54, 75, 'Sögütlü'),"+
                "(710, 54, 80, 'Taraklı'),"+
                "(711, 55, 0, 'Merkez'),"+
                "(712, 55, 25, 'Alaçam'),"+
                "(713, 55, 30, 'Asarcık'),"+
                "(714, 55, 35, 'Ayvacık'),"+
                "(715, 55, 40, 'Bafra'),"+
                "(716, 55, 45, 'Çarşamba'),"+
                "(717, 55, 50, 'Havza'),"+
                "(718, 55, 55, 'Kavak'),"+
                "(719, 55, 60, 'Ladik'),"+
                "(720, 55, 65, '19mayis'),"+
                "(721, 55, 70, 'Salıpazari'),"+
                "(722, 55, 75, 'Tekkeköy'),"+
                "(723, 55, 80, 'Terme'),"+
                "(724, 55, 85, 'Vezirköprü'),"+
                "(725, 55, 90, 'Yakakent'),"+
                "(726, 56, 0, 'Merkez'),"+
                "(727, 56, 25, 'Aydinlar'),"+
                "(728, 56, 30, 'Baykan'),"+
                "(729, 56, 35, 'Eruh'),"+
                "(730, 56, 42, 'Kozluk'),"+
                "(731, 56, 45, 'Kurtalan'),"+
                "(732, 56, 50, 'Pervari'),"+
                "(733, 56, 55, 'Şirvan'),"+
                "(734, 57, 0, 'Merkez'),"+
                "(735, 57, 25, 'Ayancık'),"+
                "(736, 57, 30, 'Boyabat'),"+
                "(737, 57, 35, 'Dikmen'),"+
                "(738, 57, 40, 'Duragan'),"+
                "(739, 57, 45, 'Erfelek'),"+
                "(740, 57, 50, 'Gerze'),"+
                "(741, 57, 55, 'Saraydüzü'),"+
                "(742, 57, 60, 'Türkeli'),"+
                "(743, 58, 0, 'Merkez'),"+
                "(744, 58, 24, 'Akincilar'),"+
                "(745, 58, 28, 'Altinyayla'),"+
                "(746, 58, 32, 'Divrigi'),"+
                "(747, 58, 36, 'Dogansar'),"+
                "(748, 58, 40, 'Gemerek'),"+
                "(749, 58, 44, 'Gölova'),"+
                "(750, 58, 48, 'Gürün'),"+
                "(751, 58, 52, 'Hafik'),"+
                "(752, 58, 56, 'Imranlı'),"+
                "(753, 58, 60, 'Kangal'),"+
                "(754, 58, 64, 'Koyulhisar'),"+
                "(755, 58, 68, 'Susehri'),"+
                "(756, 58, 72, 'Sarkışla'),"+
                "(757, 58, 76, 'Ulas'),"+
                "(758, 58, 80, 'Yildizeli'),"+
                "(759, 58, 84, 'Zara'),"+
                "(760, 59, 0, 'Merkez'),"+
                "(761, 59, 25, 'Çerkezköy'),"+
                "(762, 59, 30, 'Çorlu'),"+
                "(763, 59, 35, 'Hayrabolu'),"+
                "(764, 59, 40, 'Malkara'),"+
                "(765, 59, 45, 'Marmaraeregli'),"+
                "(766, 59, 50, 'Muratli'),"+
                "(767, 59, 55, 'Saray'),"+
                "(768, 59, 60, 'Sarköy'),"+
                "(769, 60, 0, 'Merkez'),"+
                "(770, 60, 25, 'Almus'),"+
                "(771, 60, 30, 'Artova'),"+
                "(772, 60, 35, 'Basçiftlik'),"+
                "(773, 60, 40, 'Erbaa'),"+
                "(774, 60, 45, 'Niksar'),"+
                "(775, 60, 50, 'Pazar'),"+
                "(776, 60, 55, 'Resadiye'),"+
                "(777, 60, 60, 'Sulusaray'),"+
                "(778, 60, 65, 'Turhal'),"+
                "(779, 60, 70, 'Yesilyurt'),"+
                "(780, 60, 75, 'Zile'),"+
                "(781, 61, 0, 'Merkez'),"+
                "(782, 61, 24, 'Akçaabat'),"+
                "(783, 61, 28, 'Araklı'),"+
                "(784, 61, 32, 'Arsin'),"+
                "(785, 61, 36, 'Besikdüzü'),"+
                "(786, 61, 40, 'Çarsibaşı'),"+
                "(787, 61, 44, 'Çaykara'),"+
                "(788, 61, 48, 'Dernekpazar'),"+
                "(789, 61, 52, 'Düzköy'),"+
                "(790, 61, 56, 'Hayrat'),"+
                "(791, 61, 60, 'Köprübaşı'),"+
                "(792, 61, 64, 'Maçka'),"+
                "(793, 61, 68, 'Of'),"+
                "(794, 61, 72, 'Sürmene'),"+
                "(795, 61, 76, 'Salpazari'),"+
                "(796, 61, 80, 'Tonya'),"+
                "(797, 61, 84, 'Vakfikebir'),"+
                "(798, 61, 88, 'Yomra'),"+
                "(799, 62, 0, 'Merkez'),"+
                "(800, 62, 25, 'Çemisgezek'),"+
                "(801, 62, 30, 'Hozat'),"+
                "(802, 62, 35, 'Mazgirt'),"+
                "(803, 62, 40, 'Nazimiye'),"+
                "(804, 62, 45, 'Ovacık'),"+
                "(805, 62, 50, 'Pertek'),"+
                "(806, 62, 55, 'Pülümür'),"+
                "(807, 63, 0, 'Merkez'),"+
                "(808, 63, 25, 'Akçakale'),"+
                "(809, 63, 30, 'Birecik'),"+
                "(810, 63, 35, 'Bozova'),"+
                "(811, 63, 40, 'Ceylanpinar'),"+
                "(812, 63, 45, 'Halfeti'),"+
                "(813, 63, 50, 'Harran'),"+
                "(814, 63, 55, 'Hilvan'),"+
                "(815, 63, 60, 'Siverek'),"+
                "(816, 63, 65, 'Suruç'),"+
                "(817, 63, 70, 'Viransehir'),"+
                "(818, 64, 0, 'Merkez'),"+
                "(819, 64, 25, 'Banaz'),"+
                "(820, 64, 30, 'Esme'),"+
                "(821, 64, 35, 'Karahalli'),"+
                "(822, 64, 40, 'Sivaslı'),"+
                "(823, 64, 45, 'Ulubey'),"+
                "(824, 65, 0, 'Merkez'),"+
                "(825, 65, 25, 'Bahçesaray'),"+
                "(826, 65, 30, 'Baskale'),"+
                "(827, 65, 35, 'Çaldiran'),"+
                "(828, 65, 40, 'Çatak'),"+
                "(829, 65, 45, 'Edremit'),"+
                "(830, 65, 50, 'Ercis'),"+
                "(831, 65, 55, 'Gevas'),"+
                "(832, 65, 60, 'Gürpinar'),"+
                "(833, 65, 65, 'Muradiye'),"+
                "(834, 65, 70, 'Özalp'),"+
                "(835, 65, 75, 'Saray'),"+
                "(836, 66, 0, 'Merkez'),"+
                "(837, 66, 25, 'Akdagmadeni'),"+
                "(838, 66, 30, 'Aydincık'),"+
                "(839, 66, 35, 'Bogazliyan'),"+
                "(840, 66, 40, 'Çandir'),"+
                "(841, 66, 45, 'Çayiralan'),"+
                "(842, 66, 50, 'Çekerek'),"+
                "(843, 66, 55, 'Kadisehri'),"+
                "(844, 66, 60, 'Sarikaya'),"+
                "(845, 66, 65, 'Saraykent'),"+
                "(846, 66, 70, 'Sorgun'),"+
                "(847, 66, 75, 'Sefaatli'),"+
                "(848, 66, 80, 'Yenifakili'),"+
                "(849, 66, 85, 'Yerköy'),"+
                "(850, 67, 0, 'Merkez'),"+
                "(851, 67, 24, 'Alapli'),"+
                "(852, 67, 36, 'Çamoluk'),"+
                "(853, 67, 38, 'Çaycuma'),"+
                "(854, 67, 44, 'Devrek'),"+
                "(855, 67, 52, 'Eflani'),"+
                "(856, 67, 56, 'Eregli'),"+
                "(857, 67, 60, 'Gökçebey'),"+
                "(858, 68, 0, 'Merkez'),"+
                "(859, 68, 25, 'Agaçören'),"+
                "(860, 68, 30, 'Eskil'),"+
                "(861, 68, 35, 'Gülagaç'),"+
                "(862, 68, 40, 'Güzelyurt'),"+
                "(863, 68, 45, 'Ortaköy'),"+
                "(864, 68, 50, 'Sariyahsi'),"+
                "(865, 69, 0, 'Merkez'),"+
                "(866, 69, 25, 'Aydintepe'),"+
                "(867, 69, 30, 'Demirözü'),"+
                "(868, 70, 0, 'Merkez'),"+
                "(869, 70, 25, 'Ayranci'),"+
                "(870, 70, 30, 'Basyayla'),"+
                "(871, 70, 35, 'Ermenek'),"+
                "(872, 70, 40, 'Kazimkarabekir'),"+
                "(873, 70, 45, 'Sariveliler'),"+
                "(874, 71, 0, 'Merkez'),"+
                "(875, 71, 25, 'Bahsili'),"+
                "(876, 71, 30, 'Bagliseyh'),"+
                "(877, 71, 35, 'Çelebi'),"+
                "(878, 71, 40, 'Delice'),"+
                "(879, 71, 45, 'Karakeçili'),"+
                "(880, 71, 50, 'Keskin'),"+
                "(881, 71, 55, 'Sulakyurt'),"+
                "(882, 71, 60, 'Yahsihan'),"+
                "(883, 72, 0, 'Merkez'),"+
                "(884, 72, 25, 'Gercüs'),"+
                "(885, 72, 30, 'Hasankeyf'),"+
                "(886, 72, 35, 'Besiri'),"+
                "(887, 72, 37, 'Kozluk'),"+
                "(888, 72, 40, 'Sason'),"+
                "(889, 73, 0, 'Merkez'),"+
                "(890, 73, 25, 'Beytüsseba'),"+
                "(891, 73, 30, 'Uludere'),"+
                "(892, 73, 35, 'Cizre'),"+
                "(893, 73, 40, 'Idil'),"+
                "(894, 73, 45, 'Silopi'),"+
                "(895, 73, 55, 'Güçlükonak'),"+
                "(896, 74, 0, 'Merkez'),"+
                "(897, 74, 20, 'Amasra'),"+
                "(898, 74, 30, 'Kurucaşile'),"+
                "(899, 74, 40, 'Ulus'),"+
                "(900, 75, 0, 'Merkez'),"+
                "(901, 75, 30, 'Çildir'),"+
                "(902, 75, 35, 'Damal'),"+
                "(903, 75, 50, 'Göle'),"+
                "(904, 75, 55, 'Hanak'),"+
                "(905, 75, 75, 'Posof'),"+
                "(906, 76, 0, 'Merkez'),"+
                "(907, 76, 25, 'Aralik'),"+
                "(908, 76, 50, 'Karakoyunlu'),"+
                "(909, 76, 75, 'Tuzluca'),"+
                "(910, 77, 0, 'Merkez'),"+
                "(911, 77, 10, 'Altinova'),"+
                "(912, 77, 15, 'Armutlu'),"+
                "(913, 77, 20, 'Cinarcık'),"+
                "(914, 77, 22, 'Ciftlikkoy'),"+
                "(915, 77, 80, 'Termal'),"+
                "(916, 78, 0, 'Merkez'),"+
                "(917, 78, 30, 'Eflani'),"+
                "(918, 78, 33, 'Eskipazar'),"+
                "(919, 78, 50, 'Ovacık'),"+
                "(920, 78, 70, 'Safranbolu'),"+
                "(921, 78, 90, 'Yenice'),"+
                "(922, 79, 0, 'Merkez'),"+
                "(923, 79, 30, 'Elbeyli'),"+
                "(924, 79, 50, 'Musabeyli'),"+
                "(925, 79, 60, 'Polateli'),"+
                "(926, 80, 0, 'Merkez'),"+
                "(927, 80, 20, 'Bahçe'),"+
                "(928, 80, 23, 'Hasanbeyli'),"+
                "(929, 80, 25, 'Düziçi'),"+
                "(930, 80, 30, 'Kadirli'),"+
                "(931, 80, 45, 'Sunbas'),"+
                "(932, 80, 50, 'Toprakkale'),"+
                "(933, 81, 0, 'Merkez'),"+
                "(934, 81, 20, 'Akçakoca'),"+
                "(935, 81, 25, 'Cumayeri'),"+
                "(936, 81, 30, 'Çilimli'),"+
                "(937, 81, 35, 'Gölyaka'),"+
                "(938, 81, 40, 'Gümüsova'),"+
                "(939, 81, 45, 'Kaynaşlı'),"+
                "(940, 81, 50, 'Yiğilca'),"+
                "(941, 3, 0, 'Sinanpaşa'),"+
                "(942, 9, 0, 'Didim'),"+
                "(943, 41, 0, 'Derince');";



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
