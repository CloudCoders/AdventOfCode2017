
def reverse(sequence, ini, length):

    size = len(sequence)
    list_to_reverse = []

    if length > size:
        length = size

    for i in range(length):
        list_to_reverse.append(sequence[(ini+i) % size])

    reversed_list = list(reversed(list_to_reverse))

    for i in range(length):
        sequence[(ini + i) % size] = reversed_list[i]

    return sequence


def knot_hash(sequence, lengths, iterations=1):

    size = len(sequence)
    lengths = [int(x) for x in lengths]
    pos = 0
    skip_size = 0

    for i in range(iterations):

        for length in lengths:

            sequence = reverse(sequence, pos, length)

            pos += length
            pos += skip_size
            pos = pos % size
            skip_size += 1

    return sequence


def decode_to_ascii(sequence):
    res = [ord(c) for c in sequence]
    return res


def add_suffix(sequence):
    return sequence + [17, 31, 73, 47, 23]


def solve_part_1(lengths, sequence=[x for x in range(256)]):
    result = knot_hash(sequence, lengths)
    return result[0]*result[1]


def densify(sparse_hash):

    dense_hash = []
    for i in range(0, 16):

        xor_result = sparse_hash[i]^sparse_hash[i+1]

        for j in range(2,16):
            xor_result = xor_result ^ sparse_hash[i+j]

        dense_hash.append(xor_result)

    return dense_hash


def encode_in_hex(sequence):

    res = ''
    for elem in sequence:
        hex_code = hex(elem)[2:]
        if len(hex_code) < 2:
            hex_code = '0'+hex_code
        res += hex_code
    return res


def solve_part_2(lengths):

    sequence = [x for x in range(256)]
    lengths = add_suffix(decode_to_ascii(lengths))
    sparse_hash = knot_hash(sequence, lengths, iterations=64)
    dense_hash = densify(sparse_hash)

    return encode_in_hex(dense_hash)

