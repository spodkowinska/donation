
$(function() {

    $("#donationForm").validate({
            rules: {
                quantity: {
                    required: true,
                    min: 1,
                    max: 10
                },
                categories: {
                    required: true
                },
                institution: {
                    required: true
                },
                zipCode: "required",
                pickUpDate: {
                    required: true,
                    future: true
                },
                pickUpTime: "required"
            },

            messages: {
                quantity: {
                    required: "Proszę uzupełnić liczbę worków",
                    min: "Minimalna ilość worków wynosi 3",
                    max: "Maksymalna ilość worków wynosi 10"
                },
                categories: {
                    required: "Proszę uzupełnić przynajmniej jedną kategorię"
                },
                institution: {
                    required: "Proszę uzupełnić instytucję"
                },
                zipCode: "Podano niepoprawny kod pocztowy",
                pickUpDate: {
                    required: "Podano niepoprawną datę",
                    future: "Podana data nie jest w przyszłosci"
                },
                pickUpTime: "Proszę uzupełnić godzinę"
            },
        submitHandler :function(donationForm) {
            donationForm.submit();
        }
        });
 });
