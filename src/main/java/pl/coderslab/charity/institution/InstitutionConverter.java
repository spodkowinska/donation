//package pl.coderslab.charity.institution;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.convert.converter.Converter;
//public class InstitutionConverter implements Converter<String, Institution>{
//
//        @Autowired
//        private InstitutionService institutionService;
//
//        @Override
//        public Institution convert(String s) {
//            if(s ==null || s.isEmpty()) {
//                return null;
//            }
//            return institutionService.findOne(Long.parseLong(s));
//        }
//    }
