def get_encoded_string(string):

    encoded_string = ""
    count = 1

    for index in range(len(string) - 1):

        if string[index] == string[index + 1]:
            count += 1
        else:
            encoded_string += string[index]
            if count > 1:
                encoded_string += str(count)
            count = 1

    encoded_string += string[-1]
    if count > 1:
        encoded_string += str(count)

    return encoded_string