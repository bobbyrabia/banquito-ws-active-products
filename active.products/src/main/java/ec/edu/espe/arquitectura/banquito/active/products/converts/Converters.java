package ec.edu.espe.arquitectura.banquito.active.products.converts;

import java.util.List;

import org.modelmapper.ModelMapper;
import java.lang.reflect.Type;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductRequest;
import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductResponse;
import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanProductSelectResponse;
import ec.edu.espe.arquitectura.banquito.active.products.Dto.LoanRequirementsDto;
import ec.edu.espe.arquitectura.banquito.active.products.Dto.ProductArrearsSettingDto;
import ec.edu.espe.arquitectura.banquito.active.products.model.LoanProduct;
import ec.edu.espe.arquitectura.banquito.active.products.model.LoanRequirement;
import ec.edu.espe.arquitectura.banquito.active.products.model.ProductArrearsSetting;

@Component
public class Converters {
    private final ModelMapper modelMapper;

    public Converters(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // ProductArrears
    public ProductArrearsSettingDto convertProductArrearsSettingToDto(ProductArrearsSetting productArrearsSetting) {
        ProductArrearsSettingDto productArrearsSettingDto = modelMapper.map(productArrearsSetting,
                ProductArrearsSettingDto.class);
        return productArrearsSettingDto;
    }

    public ProductArrearsSetting convertProductArrearsSettingToEntity(
            ProductArrearsSettingDto productArrearsSettingDto) {
        ProductArrearsSetting productArrearsSetting = modelMapper.map(productArrearsSettingDto,
                ProductArrearsSetting.class);
        return productArrearsSetting;
    }

    // LoanRequirements

    public LoanRequirementsDto convertLoanRequirementsToDto(LoanRequirement loanRequirement) {
        LoanRequirementsDto loanRequirementsDto = modelMapper.map(loanRequirement, LoanRequirementsDto.class);
        return loanRequirementsDto;
    }

    public LoanRequirement convertLoanRequirementsToEntity(LoanRequirementsDto loanRequirementsDto) {
        LoanRequirement loanRequirement = modelMapper.map(loanRequirementsDto, LoanRequirement.class);
        return loanRequirement;
    }

    public List<LoanRequirementsDto> convertIndicadorEntityToIndicadorDtoList(List<LoanRequirement> loanRequirements) {
        Type listType = new TypeToken<List<LoanRequirementsDto>>() {
        }.getType();
        List<LoanRequirementsDto> loanRequirementsDtos = modelMapper.map(loanRequirements, listType);
        return loanRequirementsDtos;
    }

    // Loanproduct
    public LoanProductResponse convertLoanProductToDto(LoanProduct loanProduct) {
        LoanProductResponse loanProductResponse = modelMapper.map(loanProduct, LoanProductResponse.class);
        return loanProductResponse;
    }

    public LoanProduct convertLoanProductToEntity(LoanProductRequest loanProductRequest) {
        LoanProduct loanProduct = modelMapper.map(loanProductRequest, LoanProduct.class);
        return loanProduct;
    }

        public List<LoanProductResponse> convertLoanProductToDtoList(List<LoanProduct> loanProducts) {
        Type listType = new TypeToken<List<LoanProductResponse>>() {
        }.getType();
        List<LoanProductResponse> loanProductResponses = modelMapper.map(loanProducts, listType);
        return loanProductResponses;
    }

            public List<LoanProductSelectResponse> convertLoanProductToDtoSelectList(List<LoanProduct> loanProducts) {
        Type listType = new TypeToken<List<LoanProductSelectResponse>>() {
        }.getType();
        List<LoanProductSelectResponse> loanProductSelectResponses = modelMapper.map(loanProducts, listType);
        return loanProductSelectResponses;
    }

}
