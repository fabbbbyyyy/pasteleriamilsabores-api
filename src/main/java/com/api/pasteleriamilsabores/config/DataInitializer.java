package com.api.pasteleriamilsabores.config;

import com.api.pasteleriamilsabores.model.PaymentMethod;
import com.api.pasteleriamilsabores.model.Product;
import com.api.pasteleriamilsabores.model.ProductType;
import com.api.pasteleriamilsabores.model.Rol;
import com.api.pasteleriamilsabores.repository.PaymentMethodRepository;
import com.api.pasteleriamilsabores.repository.ProductRepository;
import com.api.pasteleriamilsabores.repository.ProductTypeRepository;
import com.api.pasteleriamilsabores.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public void run(String... args) throws Exception {
        // Inicializar métodos de pago si no existen
        if (paymentMethodRepository.count() == 0) {
            System.out.println("Inicializando métodos de pago...");

            PaymentMethod efectivo = new PaymentMethod();
            efectivo.setName("Efectivo");
            paymentMethodRepository.save(efectivo);

            PaymentMethod tarjeta = new PaymentMethod();
            tarjeta.setName("Tarjeta de Crédito");
            paymentMethodRepository.save(tarjeta);

            PaymentMethod transferencia = new PaymentMethod();
            transferencia.setName("Transferencia Bancaria");
            paymentMethodRepository.save(transferencia);

            PaymentMethod paypal = new PaymentMethod();
            paypal.setName("PayPal");
            paymentMethodRepository.save(paypal);

            System.out.println("✅ Métodos de pago inicializados correctamente");
        }

        if (rolRepository.count() == 0) {
            System.out.println("Inicializando roles...");

            Rol admin = new Rol();
            admin.setName("admin");
            rolRepository.save(admin);

            Rol cliente = new Rol();
            cliente.setName("cliente");
            rolRepository.save(cliente);

        }

        if (productTypeRepository.count() == 0) {
            System.out.println("Inicializando tipos de producto..");

            ProductType circular = new ProductType();
            circular.setName("circular");
            productTypeRepository.save(circular);

            ProductType cuadrada = new ProductType();
            cuadrada.setName("cuadrada");
            productTypeRepository.save(cuadrada);

            ProductType individual = new ProductType();
            individual.setName("individual");
            productTypeRepository.save(individual);

            ProductType sinAzucar = new ProductType();
            sinAzucar.setName("sinazucar");
            productTypeRepository.save(sinAzucar);

            ProductType tradicional = new ProductType();
            tradicional.setName("tradicional");
            productTypeRepository.save(tradicional);

            ProductType sinGluten = new ProductType();
            sinGluten.setName("singluten");
            productTypeRepository.save(sinGluten);

            ProductType vegano = new ProductType();
            vegano.setName("vegano");
            productTypeRepository.save(vegano);

            ProductType especial = new ProductType();
            especial.setName("especial");
            productTypeRepository.save(especial);
            System.out.println("✅ Tipos de producto inicializados correctamente");
        }
        if (productRepository.count() == 0) {
            System.out.println("Inicializando Productos..");


            // Asumo IDs de ProductType: 1=circular, 2=cuadrada, 3=individual, 4=sinazucar,
            // 5=tradicional, 6=singluten, 7=vegano, 8=especial

            // ========== TORTAS CIRCULARES (10 productos) ==========
            Product p1 = new Product();
            p1.setName("Torta Circular de Vainilla");
            p1.setDescription("Bizcocho de vainilla clásico relleno con crema pastelera y cubierto con un glaseado dulce, perfecto para cualquier ocasión.");
            p1.setPrice(25000);
            ProductType pt1 = new ProductType(); pt1.setId(1L); p1.setProductType(pt1);
            productRepository.save(p1);

            Product p2 = new Product();
            p2.setName("Torta Circular de Manjar");
            p2.setDescription("Torta tradicional chilena con manjar y nueces, un deleite para los amantes de los sabores dulces y clásicos.");
            p2.setPrice(42000);
            ProductType pt2 = new ProductType(); pt2.setId(1L); p2.setProductType(pt2);
            productRepository.save(p2);

            Product p3 = new Product();
            p3.setName("Torta Circular de Chocolate");
            p3.setDescription("Exquisita torta de chocolate con cobertura de ganache oscuro, perfecta para los amantes del cacao.");
            p3.setPrice(23000);
            ProductType pt3 = new ProductType(); pt3.setId(1L); p3.setProductType(pt3);
            productRepository.save(p3);

            Product p4 = new Product();
            p4.setName("Torta Circular de Fresa");
            p4.setDescription("Torta circular con fresas frescas y crema chantilly, una combinación refrescante y deliciosa.");
            p4.setPrice(29990);
            ProductType pt4 = new ProductType(); pt4.setId(1L); p4.setProductType(pt4);
            productRepository.save(p4);

            Product p5 = new Product();
            p5.setName("Torta Circular de Tres Leches");
            p5.setDescription("Clásica torta empapada en tres tipos de leche, coronada con merengue italiano y canela.");
            p5.setPrice(32000);
            ProductType pt5 = new ProductType(); pt5.setId(1L); p5.setProductType(pt5);
            productRepository.save(p5);

            Product p6 = new Product();
            p6.setName("Torta Circular de Lúcuma");
            p6.setDescription("Sabor tradicional chileno con crema de lúcuma y bizcocho esponjoso, un verdadero tesoro nacional.");
            p6.setPrice(35000);
            ProductType pt6 = new ProductType(); pt6.setId(1L); p6.setProductType(pt6);
            productRepository.save(p6);

            Product p7 = new Product();
            p7.setName("Torta Circular Red Velvet");
            p7.setDescription("Elegante torta de terciopelo rojo con frosting de queso crema, perfecta para ocasiones especiales.");
            p7.setPrice(38000);
            ProductType pt7 = new ProductType(); pt7.setId(1L); p7.setProductType(pt7);
            productRepository.save(p7);

            Product p8 = new Product();
            p8.setName("Torta Circular de Zanahoria");
            p8.setDescription("Torta húmeda de zanahoria con nueces y cobertura de queso crema con canela.");
            p8.setPrice(31000);
            ProductType pt8 = new ProductType(); pt8.setId(1L); p8.setProductType(pt8);
            productRepository.save(p8);

            Product p9 = new Product();
            p9.setName("Torta Circular de Limón");
            p9.setDescription("Refrescante torta de limón con crema de limón y merengue italiano tostado.");
            p9.setPrice(28000);
            ProductType pt9 = new ProductType(); pt9.setId(1L); p9.setProductType(pt9);
            productRepository.save(p9);

            Product p10 = new Product();
            p10.setName("Torta Circular Selva Negra");
            p10.setDescription("Clásica torta alemana con chocolate, cerezas y crema chantilly, decorada con virutas de chocolate.");
            p10.setPrice(40000);
            ProductType pt10 = new ProductType(); pt10.setId(1L); p10.setProductType(pt10);
            productRepository.save(p10);

            // ========== TORTAS CUADRADAS (10 productos) ==========
            Product p11 = new Product();
            p11.setName("Torta Cuadrada de Chocolate");
            p11.setDescription("Deliciosa torta cuadrada de chocolate con ganache intenso, ideal para celebraciones especiales.");
            p11.setPrice(48000);
            ProductType pt11 = new ProductType(); pt11.setId(2L); p11.setProductType(pt11);
            productRepository.save(p11);

            Product p12 = new Product();
            p12.setName("Torta Cuadrada de Vainilla y Frambuesa");
            p12.setDescription("Elegante torta de vainilla con relleno de frambuesa y decoración floral comestible.");
            p12.setPrice(52000);
            ProductType pt12 = new ProductType(); pt12.setId(2L); p12.setProductType(pt12);
            productRepository.save(p12);

            Product p13 = new Product();
            p13.setName("Torta Cuadrada Mármol");
            p13.setDescription("Combinación perfecta de vainilla y chocolate en un diseño marmoleado único.");
            p13.setPrice(45000);
            ProductType pt13 = new ProductType(); pt13.setId(2L); p13.setProductType(pt13);
            productRepository.save(p13);

            Product p14 = new Product();
            p14.setName("Torta Cuadrada de Manjar y Coco");
            p14.setDescription("Exquisita combinación de manjar con coco rallado y crema de mantequilla.");
            p14.setPrice(49000);
            ProductType pt14 = new ProductType(); pt14.setId(2L); p14.setProductType(pt14);
            productRepository.save(p14);

            Product p15 = new Product();
            p15.setName("Torta Cuadrada Oreo");
            p15.setDescription("Torta de chocolate con galletas Oreo trituradas y crema de queso con Oreo.");
            p15.setPrice(50000);
            ProductType pt15 = new ProductType(); pt15.setId(2L); p15.setProductType(pt15);
            productRepository.save(p15);

            Product p16 = new Product();
            p16.setName("Torta Cuadrada de Café Moka");
            p16.setDescription("Torta de café con crema de moka y decoración de granos de café caramelizados.");
            p16.setPrice(47000);
            ProductType pt16 = new ProductType(); pt16.setId(2L); p16.setProductType(pt16);
            productRepository.save(p16);

            Product p17 = new Product();
            p17.setName("Torta Cuadrada de Piña Colada");
            p17.setDescription("Tropical torta con piña natural, coco y un toque de ron, decorada con crema de coco.");
            p17.setPrice(46000);
            ProductType pt17 = new ProductType(); pt17.setId(2L); p17.setProductType(pt17);
            productRepository.save(p17);

            Product p18 = new Product();
            p18.setName("Torta Cuadrada Tiramisu");
            p18.setDescription("Versión en torta del clásico italiano con capas de café, mascarpone y cacao.");
            p18.setPrice(53000);
            ProductType pt18 = new ProductType(); pt18.setId(2L); p18.setProductType(pt18);
            productRepository.save(p18);

            Product p19 = new Product();
            p19.setName("Torta Cuadrada de Frutos del Bosque");
            p19.setDescription("Torta con mezcla de arándanos, frambuesas y moras frescas con crema chantilly.");
            p19.setPrice(51000);
            ProductType pt19 = new ProductType(); pt19.setId(2L); p19.setProductType(pt19);
            productRepository.save(p19);

            Product p20 = new Product();
            p20.setName("Torta Cuadrada de Chocolate Blanco");
            p20.setDescription("Delicada torta de chocolate blanco con relleno de crema y fresas.");
            p20.setPrice(54000);
            ProductType pt20 = new ProductType(); pt20.setId(2L); p20.setProductType(pt20);
            productRepository.save(p20);

            // ========== POSTRES INDIVIDUALES (10 productos) ==========
            Product p21 = new Product();
            p21.setName("Flan de Caramelo");
            p21.setDescription("Postre individual de flan con caramelo casero y frutos rojos frescos.");
            p21.setPrice(5000);
            ProductType pt21 = new ProductType(); pt21.setId(3L); p21.setProductType(pt21);
            productRepository.save(p21);

            Product p22 = new Product();
            p22.setName("Cheesecake de Fresa Individual");
            p22.setDescription("Mini cheesecake con base de galleta y cobertura de fresa natural.");
            p22.setPrice(6500);
            ProductType pt22 = new ProductType(); pt22.setId(3L); p22.setProductType(pt22);
            productRepository.save(p22);

            Product p23 = new Product();
            p23.setName("Mousse de Chocolate");
            p23.setDescription("Suave mousse de chocolate belga servido en copa con crema batida.");
            p23.setPrice(5500);
            ProductType pt23 = new ProductType(); pt23.setId(3L); p23.setProductType(pt23);
            productRepository.save(p23);

            Product p24 = new Product();
            p24.setName("Tiramisú Individual");
            p24.setDescription("Clásico postre italiano en porción individual con café y mascarpone.");
            p24.setPrice(7000);
            ProductType pt24 = new ProductType(); pt24.setId(3L); p24.setProductType(pt24);
            productRepository.save(p24);

            Product p25 = new Product();
            p25.setName("Panna Cotta de Vainilla");
            p25.setDescription("Cremosa panna cotta con coulis de frutos rojos y menta fresca.");
            p25.setPrice(6000);
            ProductType pt25 = new ProductType(); pt25.setId(3L); p25.setProductType(pt25);
            productRepository.save(p25);

            Product p26 = new Product();
            p26.setName("Profiteroles Rellenos");
            p26.setDescription("Tres profiteroles rellenos de crema pastelera con salsa de chocolate caliente.");
            p26.setPrice(5800);
            ProductType pt26 = new ProductType(); pt26.setId(3L); p26.setProductType(pt26);
            productRepository.save(p26);

            Product p27 = new Product();
            p27.setName("Brownie con Helado");
            p27.setDescription("Brownie tibio de chocolate con helado de vainilla y salsa de caramelo.");
            p27.setPrice(6200);
            ProductType pt27 = new ProductType(); pt27.setId(3L); p27.setProductType(pt27);
            productRepository.save(p27);

            Product p28 = new Product();
            p28.setName("Tartaleta de Limón");
            p28.setDescription("Delicada tartaleta con crema de limón y merengue tostado.");
            p28.setPrice(5500);
            ProductType pt28 = new ProductType(); pt28.setId(3L); p28.setProductType(pt28);
            productRepository.save(p28);

            Product p29 = new Product();
            p29.setName("Crème Brûlée");
            p29.setDescription("Postre francés con crema de vainilla y costra de azúcar caramelizada.");
            p29.setPrice(7500);
            ProductType pt29 = new ProductType(); pt29.setId(3L); p29.setProductType(pt29);
            productRepository.save(p29);

            Product p30 = new Product();
            p30.setName("Mini Pavlova");
            p30.setDescription("Merengue crujiente con crema chantilly y frutas tropicales frescas.");
            p30.setPrice(6800);
            ProductType pt30 = new ProductType(); pt30.setId(3L); p30.setProductType(pt30);
            productRepository.save(p30);

            // ========== PRODUCTOS SIN AZÚCAR (10 productos) ==========
            Product p31 = new Product();
            p31.setName("Torta Sin Azúcar de Chocolate");
            p31.setDescription("Torta de chocolate endulzada con stevia, sin comprometer el sabor intenso del cacao.");
            p31.setPrice(35000);
            ProductType pt31 = new ProductType(); pt31.setId(4L); p31.setProductType(pt31);
            productRepository.save(p31);

            Product p32 = new Product();
            p32.setName("Torta Sin Azúcar de Zanahoria");
            p32.setDescription("Saludable torta de zanahoria con nueces y frosting sin azúcar de queso crema.");
            p32.setPrice(33000);
            ProductType pt32 = new ProductType(); pt32.setId(4L); p32.setProductType(pt32);
            productRepository.save(p32);

            Product p33 = new Product();
            p33.setName("Cheesecake Sin Azúcar");
            p33.setDescription("Cremoso cheesecake endulzado naturalmente con eritritol y frutos rojos.");
            p33.setPrice(38000);
            ProductType pt33 = new ProductType(); pt33.setId(4L); p33.setProductType(pt33);
            productRepository.save(p33);

            Product p34 = new Product();
            p34.setName("Brownies Sin Azúcar");
            p34.setDescription("Pack de 6 brownies de chocolate sin azúcar añadida, endulzados con sucralosa.");
            p34.setPrice(15000);
            ProductType pt34 = new ProductType(); pt34.setId(4L); p34.setProductType(pt34);
            productRepository.save(p34);

            Product p35 = new Product();
            p35.setName("Muffins Sin Azúcar de Arándanos");
            p35.setDescription("Pack de 4 muffins con arándanos frescos y endulzante natural.");
            p35.setPrice(12000);
            ProductType pt35 = new ProductType(); pt35.setId(4L); p35.setProductType(pt35);
            productRepository.save(p35);

            Product p36 = new Product();
            p36.setName("Torta Sin Azúcar de Limón");
            p36.setDescription("Refrescante torta de limón sin azúcar con glaseado natural.");
            p36.setPrice(32000);
            ProductType pt36 = new ProductType(); pt36.setId(4L); p36.setProductType(pt36);
            productRepository.save(p36);

            Product p37 = new Product();
            p37.setName("Galletas Sin Azúcar Mix");
            p37.setDescription("Caja con 12 galletas variadas sin azúcar: avena, chocolate y coco.");
            p37.setPrice(10000);
            ProductType pt37 = new ProductType(); pt37.setId(4L); p37.setProductType(pt37);
            productRepository.save(p37);

            Product p38 = new Product();
            p38.setName("Pie Sin Azúcar de Manzana");
            p38.setDescription("Pie de manzana con canela, endulzado naturalmente con manzanas y stevia.");
            p38.setPrice(28000);
            ProductType pt38 = new ProductType(); pt38.setId(4L); p38.setProductType(pt38);
            productRepository.save(p38);

            Product p39 = new Product();
            p39.setName("Mousse Sin Azúcar de Chocolate Oscuro");
            p39.setDescription("Postre individual de mousse de chocolate 70% cacao sin azúcar añadida.");
            p39.setPrice(6500);
            ProductType pt39 = new ProductType(); pt39.setId(4L); p39.setProductType(pt39);
            productRepository.save(p39);

            Product p40 = new Product();
            p40.setName("Torta Sin Azúcar Red Velvet");
            p40.setDescription("Elegante red velvet sin azúcar con frosting de queso crema endulzado naturalmente.");
            p40.setPrice(40000);
            ProductType pt40 = new ProductType(); pt40.setId(4L); p40.setProductType(pt40);
            productRepository.save(p40);

            // ========== PASTELERÍA TRADICIONAL (10 productos) ==========
            Product p41 = new Product();
            p41.setName("Mil Hojas Clásica");
            p41.setDescription("Tradicional torta chilena de mil hojas con manjar y hojaldre crujiente.");
            p41.setPrice(45000);
            ProductType pt41 = new ProductType(); pt41.setId(5L); p41.setProductType(pt41);
            productRepository.save(p41);

            Product p42 = new Product();
            p42.setName("Brazo de Reina");
            p42.setDescription("Clásico brazo de reina relleno con manjar y espolvoreado con azúcar flor.");
            p42.setPrice(18000);
            ProductType pt42 = new ProductType(); pt42.setId(5L); p42.setProductType(pt42);
            productRepository.save(p42);

            Product p43 = new Product();
            p43.setName("Pie de Limón");
            p43.setDescription("Tradicional pie con relleno de limón y merengue italiano tostado.");
            p43.setPrice(30000);
            ProductType pt43 = new ProductType(); pt43.setId(5L); p43.setProductType(pt43);
            productRepository.save(p43);

            Product p44 = new Product();
            p44.setName("Kuchen de Manzana");
            p44.setDescription("Tradicional kuchen alemán con manzanas caramelizadas y canela.");
            p44.setPrice(25000);
            ProductType pt44 = new ProductType(); pt44.setId(5L); p44.setProductType(pt44);
            productRepository.save(p44);

            Product p45 = new Product();
            p45.setName("Chilenitos Rellenos");
            p45.setDescription("Docena de chilenitos tradicionales rellenos con manjar.");
            p45.setPrice(12000);
            ProductType pt45 = new ProductType(); pt45.setId(5L); p45.setProductType(pt45);
            productRepository.save(p45);

            Product p46 = new Product();
            p46.setName("Torta de Hojas");
            p46.setDescription("Clásica torta de hojas con crema de mantequilla y nueces.");
            p46.setPrice(38000);
            ProductType pt46 = new ProductType(); pt46.setId(5L); p46.setProductType(pt46);
            productRepository.save(p46);

            Product p47 = new Product();
            p47.setName("Alfajores Artesanales");
            p47.setDescription("Caja de 8 alfajores artesanales rellenos con manjar y bañados en chocolate.");
            p47.setPrice(14000);
            ProductType pt47 = new ProductType(); pt47.setId(5L); p47.setProductType(pt47);
            productRepository.save(p47);

            Product p48 = new Product();
            p48.setName("Torta Lúcuma Tradicional");
            p48.setDescription("Auténtica torta de lúcuma con bizcocho de vainilla y crema de lúcuma.");
            p48.setPrice(36000);
            ProductType pt48 = new ProductType(); pt48.setId(5L); p48.setProductType(pt48);
            productRepository.save(p48);

            Product p49 = new Product();
            p49.setName("Empanadas de Manzana");
            p49.setDescription("Media docena de empanadas dulces rellenas con manzana y canela.");
            p49.setPrice(10000);
            ProductType pt49 = new ProductType(); pt49.setId(5L); p49.setProductType(pt49);
            productRepository.save(p49);

            Product p50 = new Product();
            p50.setName("Sopaipillas Pasadas");
            p50.setDescription("Docena de sopaipillas pasadas con chancaca tradicional.");
            p50.setPrice(8000);
            ProductType pt50 = new ProductType(); pt50.setId(5L); p50.setProductType(pt50);
            productRepository.save(p50);

            // ========== PRODUCTOS SIN GLUTEN (10 productos) ==========
            Product p51 = new Product();
            p51.setName("Torta Sin Gluten de Chocolate");
            p51.setDescription("Deliciosa torta de chocolate elaborada con harinas sin gluten certificadas.");
            p51.setPrice(42000);
            ProductType pt51 = new ProductType(); pt51.setId(6L); p51.setProductType(pt51);
            productRepository.save(p51);

            Product p52 = new Product();
            p52.setName("Torta Sin Gluten de Zanahoria");
            p52.setDescription("Húmeda torta de zanahoria sin gluten con nueces y frosting de queso crema.");
            p52.setPrice(40000);
            ProductType pt52 = new ProductType(); pt52.setId(6L); p52.setProductType(pt52);
            productRepository.save(p52);

            Product p53 = new Product();
            p53.setName("Brownies Sin Gluten");
            p53.setDescription("Pack de 6 brownies intensos de chocolate sin gluten.");
            p53.setPrice(16000);
            ProductType pt53 = new ProductType(); pt53.setId(6L); p53.setProductType(pt53);
            productRepository.save(p53);

            Product p54 = new Product();
            p54.setName("Muffins Sin Gluten de Frambuesa");
            p54.setDescription("Pack de 4 muffins esponjosos con frambuesas frescas, sin gluten.");
            p54.setPrice(13000);
            ProductType pt54 = new ProductType(); pt54.setId(6L); p54.setProductType(pt54);
            productRepository.save(p54);

            Product p55 = new Product();
            p55.setName("Cheesecake Sin Gluten");
            p55.setDescription("Cremoso cheesecake con base de galletas sin gluten y frutos rojos.");
            p55.setPrice(45000);
            ProductType pt55 = new ProductType(); pt55.setId(6L); p55.setProductType(pt55);
            productRepository.save(p55);

            Product p56 = new Product();
            p56.setName("Torta Sin Gluten de Limón");
            p56.setDescription("Refrescante torta de limón con harina de almendras, completamente sin gluten.");
            p56.setPrice(38000);
            ProductType pt56 = new ProductType(); pt56.setId(6L); p56.setProductType(pt56);
            productRepository.save(p56);

            Product p57 = new Product();
            p57.setName("Galletas Sin Gluten Variadas");
            p57.setDescription("Caja de 12 galletas sin gluten: chocolate chip, avena y coco.");
            p57.setPrice(11000);
            ProductType pt57 = new ProductType(); pt57.setId(6L); p57.setProductType(pt57);
            productRepository.save(p57);

            Product p58 = new Product();
            p58.setName("Cupcakes Sin Gluten");
            p58.setDescription("Set de 6 cupcakes decorados, elaborados con ingredientes sin gluten.");
            p58.setPrice(18000);
            ProductType pt58 = new ProductType(); pt58.setId(6L); p58.setProductType(pt58);
            productRepository.save(p58);

            Product p59 = new Product();
            p59.setName("Pie Sin Gluten de Manzana");
            p59.setDescription("Pie de manzana con masa sin gluten y relleno de manzanas con canela.");
            p59.setPrice(32000);
            ProductType pt59 = new ProductType(); pt59.setId(6L); p59.setProductType(pt59);
            productRepository.save(p59);

            Product p60 = new Product();
            p60.setName("Torta Sin Gluten Red Velvet");
            p60.setDescription("Elegante red velvet sin gluten con frosting de queso crema.");
            p60.setPrice(46000);
            ProductType pt60 = new ProductType(); pt60.setId(6L); p60.setProductType(pt60);
            productRepository.save(p60);

            // ========== PRODUCTOS VEGANOS (10 productos) ==========
            Product p61 = new Product();
            p61.setName("Torta Vegana de Chocolate");
            p61.setDescription("Torta de chocolate 100% vegana, sin huevo ni lácteos, con ganache vegano.");
            p61.setPrice(38000);
            ProductType pt61 = new ProductType(); pt61.setId(7L); p61.setProductType(pt61);
            productRepository.save(p61);

            Product p62 = new Product();
            p62.setName("Torta Vegana de Zanahoria");
            p62.setDescription("Torta de zanahoria vegana con nueces y frosting de anacardos.");
            p62.setPrice(36000);
            ProductType pt62 = new ProductType(); pt62.setId(7L); p62.setProductType(pt62);
            productRepository.save(p62);

            Product p63 = new Product();
            p63.setName("Brownies Veganos");
            p63.setDescription("Pack de 6 brownies veganos con chocolate oscuro y nueces.");
            p63.setPrice(14000);
            ProductType pt63 = new ProductType(); pt63.setId(7L); p63.setProductType(pt63);
            productRepository.save(p63);

            Product p64 = new Product();
            p64.setName("Muffins Veganos de Arándanos");
            p64.setDescription("Pack de 4 muffins veganos con arándanos frescos y semillas de chía.");
            p64.setPrice(12000);
            ProductType pt64 = new ProductType(); pt64.setId(7L); p64.setProductType(pt64);
            productRepository.save(p64);

            Product p65 = new Product();
            p65.setName("Cheesecake Vegano de Fresa");
            p65.setDescription("Cheesecake vegano con base de dátiles y crema de anacardos, cubierto con fresas.");
            p65.setPrice(42000);
            ProductType pt65 = new ProductType(); pt65.setId(7L); p65.setProductType(pt65);
            productRepository.save(p65);

            Product p66 = new Product();
            p66.setName("Torta Vegana de Limón");
            p66.setDescription("Torta vegana de limón con glaseado de limón y leche de coco.");
            p66.setPrice(35000);
            ProductType pt66 = new ProductType(); pt66.setId(7L); p66.setProductType(pt66);
            productRepository.save(p66);

            Product p67 = new Product();
            p67.setName("Galletas Veganas Mix");
            p67.setDescription("Caja de 12 galletas veganas: chocolate chip, avena-pasas y coco.");
            p67.setPrice(10000);
            ProductType pt67 = new ProductType(); pt67.setId(7L); p67.setProductType(pt67);
            productRepository.save(p67);

            Product p68 = new Product();
            p68.setName("Cupcakes Veganos de Vainilla");
            p68.setDescription("Set de 6 cupcakes veganos con frosting de vainilla y decoración colorida.");
            p68.setPrice(16000);
            ProductType pt68 = new ProductType(); pt68.setId(7L); p68.setProductType(pt68);
            productRepository.save(p68);

            Product p69 = new Product();
            p69.setName("Torta Vegana Red Velvet");
            p69.setDescription("Red velvet vegano con frosting de queso crema vegano a base de anacardos.");
            p69.setPrice(44000);
            ProductType pt69 = new ProductType(); pt69.setId(7L); p69.setProductType(pt69);
            productRepository.save(p69);

            Product p70 = new Product();
            p70.setName("Pie Vegano de Manzana");
            p70.setDescription("Pie de manzana con masa vegana y relleno de manzanas especiadas.");
            p70.setPrice(30000);
            ProductType pt70 = new ProductType(); pt70.setId(7L); p70.setProductType(pt70);
            productRepository.save(p70);

            // ========== TORTAS ESPECIALES (10 productos) ==========
            Product p71 = new Product();
            p71.setName("Torta de Tres Chocolates");
            p71.setDescription("Elegante torta con capas de chocolate blanco, con leche y oscuro.");
            p71.setPrice(55000);
            ProductType pt71 = new ProductType(); pt71.setId(8L); p71.setProductType(pt71);
            productRepository.save(p71);

            Product p72 = new Product();
            p72.setName("Torta Ópera");
            p72.setDescription("Sofisticada torta francesa con capas de café, ganache y crema de mantequilla.");
            p72.setPrice(58000);
            ProductType pt72 = new ProductType(); pt72.setId(8L); p72.setProductType(pt72);
            productRepository.save(p72);

            Product p73 = new Product();
            p73.setName("Torta Sacher Vienesa");
            p73.setDescription("Clásica torta austriaca de chocolate con mermelada de damasco y chocolate.");
            p73.setPrice(52000);
            ProductType pt73 = new ProductType(); pt73.setId(8L); p73.setProductType(pt73);
            productRepository.save(p73);

            Product p74 = new Product();
            p74.setName("Torta Unicornio");
            p74.setDescription("Colorida torta de vainilla con decoración de unicornio y arcoíris comestible.");
            p74.setPrice(48000);
            ProductType pt74 = new ProductType(); pt74.setId(8L); p74.setProductType(pt74);
            productRepository.save(p74);

            Product p75 = new Product();
            p75.setName("Torta de Maracuyá");
            p75.setDescription("Tropical torta con mousse de maracuyá y bizcocho de vainilla.");
            p75.setPrice(47000);
            ProductType pt75 = new ProductType(); pt75.setId(8L); p75.setProductType(pt75);
            productRepository.save(p75);

            Product p76 = new Product();
            p76.setName("Torta de Té Matcha");
            p76.setDescription("Exótica torta de té verde matcha con crema de chocolate blanco.");
            p76.setPrice(50000);
            ProductType pt76 = new ProductType(); pt76.setId(8L); p76.setProductType(pt76);
            productRepository.save(p76);

            Product p77 = new Product();
            p77.setName("Torta Arcoíris");
            p77.setDescription("Impresionante torta con 6 capas de colores del arcoíris y frosting blanco.");
            p77.setPrice(54000);
            ProductType pt77 = new ProductType(); pt77.setId(8L); p77.setProductType(pt77);
            productRepository.save(p77);

            Product p78 = new Product();
            p78.setName("Torta Espejo de Chocolate");
            p78.setDescription("Sofisticada torta con cobertura espejo brillante de chocolate.");
            p78.setPrice(62000);
            ProductType pt78 = new ProductType(); pt78.setId(8L); p78.setProductType(pt78);
            productRepository.save(p78);

            Product p79 = new Product();
            p79.setName("Torta de Dulce de Leche Argentino");
            p79.setDescription("Torta especial con auténtico dulce de leche argentino y merengue italiano.");
            p79.setPrice(49000);
            ProductType pt79 = new ProductType(); pt79.setId(8L); p79.setProductType(pt79);
            productRepository.save(p79);

            Product p80 = new Product();
            p80.setName("Torta de Frambuesa y Pistacho");
            p80.setDescription("Elegante combinación de frambuesa fresca con crema de pistacho.");
            p80.setPrice(56000);
            ProductType pt80 = new ProductType(); pt80.setId(8L); p80.setProductType(pt80);
            productRepository.save(p80);

            System.out.println("✅ productos inicializados correctamente");
        }
        System.out.println("🚀 Aplicación lista para usar!");
    }
}

