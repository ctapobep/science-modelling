import org.junit.Test

import static Dna.dna

class DnaTest {

  @Test void 'reverse palindromes'() {
    assert [:] == dna('').reversePalindromes()
    assert [:] == dna('GC').reversePalindromes()
    assert [(1): 4] == dna('TGCAA').reversePalindromes()
    assert [(2): 4] == dna('ATGCA').reversePalindromes()
    assert [(1): 4] == dna('TGCA').reversePalindromes()
    assert [(1): 6, (2): 4] == dna('CACGTG').reversePalindromes()
    assert [(1): 4] == dna('ACGTGT').reversePalindromes()
    assert [(1): 12, (2): 10, (3): 8, (4): 6, (5): 4] == dna('TTTCCTAGGAAA').reversePalindromes()
    assert [(4): 6, (5): 4, (6): 6, (7): 4, (17): 4, (18): 4, (20): 6, (21): 4] ==
        dna('TCAATGCATGCGGGTCTATATGCAT').reversePalindromes()
    assert PALINDROME1.palindromes == Dna.parseFasta(PALINDROME1.fasta)[0].reversePalindromes()
  }

  @Test void 'remove introns'() {
    assert SPLICING1.resultingProtein == Dna.parseFasta(SPLICING1.originalFasta)[0].
        remove(Dna.parseFasta(SPLICING1.introns)).
        resultingProtein()
    assert SPLICING2.resultingProtein == Dna.parseFasta(SPLICING2.originalFasta)[0].
        remove(Dna.parseFasta(SPLICING2.introns)).
        resultingProtein()
  }

  @Test void 'orf open reading frames'() {
    assert ORF1.proteins == Dna.parseFasta(ORF1.fasta)[0].possibleProteinsThatCanStartAnywhere()
    assert ORF2.proteins == Dna.parseFasta(ORF2.fasta)[0].possibleProteinsThatCanStartAnywhere()
  }
  @Test void 'complementary string must be reversed and have correct pairs'() {
    assert 'ACCGGGTTTT' == dna('AAAACCCGGT').complementaryDna().sequence
  }

  @Test void 'empty fasta results in empty DNA list'() {
    assert !Dna.parseFasta('')
  }

  @Test void 'hamming distance for identical DNAs must be 0'() {
    assert 0 == dna('ACGT').hammingDistance(dna('ACGT'))
  }
  @Test void 'hamming distance > 0'() {
    assert 7 == dna('GAGCCTACTAACGGGAT').hammingDistance(dna('CATCGTAATGACGGCCT'))
    assert 457 == dna('ACGGATCTAACGTAGTAACATAAACACCACCTGCCTTTGTGATCGTGGAACAGGTCAGCTGGCAAGGGTCGGGAGGCAAGTGAAGTGAAAAATCGGGAGAGGGGTGCGATGCCATTTGACTATAATTGTTGCAAGAATGCGCACCGCCCAACAATACCTTGGGTATTACCCACCAAGTGTCGTCCGGGGGTGTCCCACAAGGGTAATGGGTGTACATCTTCAGTATTCCTCAGATCAGCGACTCGTCCGAAGCATGCCAGATCAAAGACCATTTGACAGGCTCTTACACTCTCGGTACCTAACCAATCCCTGCTAGATCGCTGACCGACCTTGTTCCATCACGTTCGTCCAGTCAACGAATTGCCATAGTATTTGGTGCAGACCCATAATTCGGGCTTGAGCATGCTTACTACTTTAGATGAGATGCCAGTGGCCAGGCTGCTGGTTAGCTTAAGCAGGCGTATCCTATGGGATGGCACAAGGCATCGTGGTGTCTCGACAGAAGTCTCTAAGTAAGCCTGCGTTTTGGTGTTCACGTCTAGTCAACCTCCCGTCTAAAGGAAGTCATTTTCGTCGTAACCGCTGAGGAAGACCGCACTCACCAGAGCGCGCACGGCATCCACACTGACCACCGATAACAATCAGTGTGTTTCAAAACAACTAGGGCGAATAGAAGCATAGTACGTCGATTGCTTACGTAACCGGATCAGGGCGCGCAGAAACTTACACCCCTAAAGGGCTCCTAATACGCCATTGTTGTCAATCGTGTAGCTAAACGGGGATTATCGTCCTAGAGTTCTAAAATGGATGGATGGCTTCAACGTCTTTTACCAACAATTCCGACGTTACAAAGGTTCGGGTTTCGTTCTACTCTCTCATGAATCGGTAATCATAAGCGCTGCTTCCAGCCTAGCGTCTGCCTGGATCTAGACTGAAACTAGCTTAGCGG')
        .hammingDistance(dna('CCCGTGCCTAAGTAGTAGTAGTGAGCGCACCTGCTTCACGGATATAGCGGGCGCGCATCCAGTAACCTTACAGAGGCAACGGGAGTGATAACACGGTCAGACCATGGGACCGCTTTACACAAGTTTTGTCGCCAGTCTGAACACCATGCGATCATGTCTTGTGGTAAAACCACCGCGTGCGATTCGAATCCGGTGTAAAGAGTTAACCTCTGTAATGCCGCTGGATGTTTACCCCCGGGGTGGCGCCTGAGTCACCACCGTTCAAATACCATCCTACAGCACATTGGACACCCGGGACCTATCGACGCAAAGATATTGCGTATACGGACCCTGGTGTGACGACTTGACCCGGCTAAGGGAACGCCTGTGGACGTGTGAAAACGGCAAAATTAGGGCTTGAGATGACCAACTATTGTCCATGAGATGACCATGGCGAGACGCATACCGTCCCTTCGCAGGAGTACCCGACTACGCGGAACAAGGCCATGGGGTACAGAGACCTAACTTGCCTCGGGATCCTGTGTTTCGACCTGCATGTAGTGTAATGCGCCGGTCTGAAGCTAGGCGTTATCGTGTCAATAGCTAAAGGAGTGCCTGATTGACAGGCTGCCCACAGCCCACACTAAGTCCATACATGACAATCTGTTACCTCTCGATCAATTAGATGGTGTCGGACAATCTTAACTCGCTCGCTAACATAAACGAATTAGAGCGTTTGCCCACTAGCGTCGCGGGAGGGCTGCTAATCCTACATTGGGCCCAGTCGTTAAAACTAAGCGCATTTAACAACCCTGATCTTGTAAATGGATCAAACACACGCCGCTATTCTAATAATTGCTCCTAGACTACGAAGGTGGGCGTATCGAGCTTATTTTTCATGCTTCCCTCGACCGCTTGCCTATTTGCCGGCTAACGAAGGGTTTGCGCTAGACTGAAATTCGCACACGGG'))
  }

  @Test void "transforming to RNA must replace all T's with U's"() {
    assert 'GAUGGAACUUGACUACGUAAAUU' == dna('GATGGAACTTGACTACGTAAATT').toRnaString()
  }

  @Test void 'find all positions of sub-sequence'() {
    assert [] == dna('').positionsOf('TT')
    assert [] == dna('ATAGGT').positionsOf('TT')
    assert [4] == dna('ATAGGT').positionsOf('GGT')//last in string
    assert [4] == dna('ATAGGT').positionsOf('GG')
    assert [1, 6] == dna('GGATAGGT').positionsOf('GG')
    assert [2, 4, 10] == dna('GATATATGCATATACTT').positionsOf('ATAT')
    assert [1, 56, 63, 93, 109, 147, 253, 260, 300, 328, 338, 380, 400, 417, 424, 441, 461, 500, 534, 570, 577, 611,
            622, 650, 678, 708, 718, 766] == dna(BIG_MOTIF_SEQ.sequence).positionsOf(BIG_MOTIF_SEQ.subsequence)
  }

  @Test void 'longest common sequence'() {
    assert '' == Dna.longestCommonSequence([])
    assert '' == Dna.longestCommonSequence([dna('AC'), dna('GT')])
    assert 'AC' == Dna.longestCommonSequence([dna('AC')])
    assert 'A' == Dna.longestCommonSequence([dna('AC'), dna('GA')])
    assert 'AC' == Dna.longestCommonSequence([dna('AC'), dna('GAC')])
    assert 'AC' == Dna.longestCommonSequence([dna('AC'), dna('GACT')])
    assert 'AC' == Dna.longestCommonSequence([dna('ACA'), dna('GACT')])
    assert 'GACT' == Dna.longestCommonSequence([dna('GACT'), dna('GACT')])
    assert LONGEST_COMMON_SEQ1.longestCommonSeq == Dna.longestCommonSequence(Dna.parseFasta(LONGEST_COMMON_SEQ1.fasta))
    assert LONGEST_COMMON_SEQ2.longestCommonSeq == Dna.longestCommonSequence(Dna.parseFasta(LONGEST_COMMON_SEQ2.fasta))
  }

  @Test void 'fasta with one DNA sequence must return one DNA'() {
    String sequence = '>Rosalind_6404\n' +
        'CCTGCGGAAGATCGGCACTAGAATAGCCAGAACCGTTTCTCTGAGGCTTCCGGCCTTCCC\n' +
        'TCCCACTAATAATTCTGAGG'
    def dnas = Dna.parseFasta(sequence)
    assert 1 == dnas.size()
    assert 'Rosalind_6404' == dnas[0].id
    assert 'CCTGCGGAAGATCGGCACTAGAATAGCCAGAACCGTTTCTCTGAGGCTTCCGGCCTTCCCTCCCACTAATAATTCTGAGG' == dnas[0].sequence
  }

  @Test void 'fasta with >1 DNA seq must return multiple DNAs'() {
    String sequence = '>Rosalind_6404\n' +
        'CCTGCGGAAGATCGGCACTAGAATAGCCAGAACCGTTTCTCTGAGGCTTCCGGCCTTCCC\n' +
        'TCCCACTAATAATTCTGAGG\n' +
        '>Rosalind_5959\n' +
        'CCATCGGTAGCGCATCCTTAGTCCAATTAAGTCCCTATCCAGGCGCTCCGCCGAAGGTCT\n' +
        'ATATCCATTTGTCAGCAGACACGC\n' +
        '>Rosalind_0808\n' +
        'CCACCCTCGTGGTATGGCTAGGCATTCAGGAACCGGAGAACGCTTCAGACCAGCCCGGAC\n' +
        'TGGGAACCTGCGGGCAGTAGGTGGAAT'
    def expectedIds = ['Rosalind_6404', 'Rosalind_5959', 'Rosalind_0808']
    def expectedSeqs = ['CCTGCGGAAGATCGGCACTAGAATAGCCAGAACCGTTTCTCTGAGGCTTCCGGCCTTCCCTCCCACTAATAATTCTGAGG',
                        'CCATCGGTAGCGCATCCTTAGTCCAATTAAGTCCCTATCCAGGCGCTCCGCCGAAGGTCTATATCCATTTGTCAGCAGACACGC',
                        'CCACCCTCGTGGTATGGCTAGGCATTCAGGAACCGGAGAACGCTTCAGACCAGCCCGGACTGGGAACCTGCGGGCAGTAGGTGGAAT']
    def dnas = Dna.parseFasta(sequence)

    assert 3 == dnas.size()
    assert expectedIds == dnas.collect { Dna it -> it.id }
    assert expectedSeqs == dnas.collect { Dna it -> it.sequence }
  }

  @Test void 'calculating GC content'() {
    assert 0D == dna('AT').gcContent()
    assert 0D == dna('').gcContent()
    assert 50D == dna('CGAT').gcContent()
    assert 100D == dna('CG').gcContent()
    assert 100D == dna('CC').gcContent()
    assert 100D == dna('GG').gcContent()
  }

  @Test void 'sort by GC content'() {
    def dnas = Dna.fromStrings('GCAT', 'GCCT', 'T')
    dnas.sort(new Dna.ByGcRatioDescComparator())
    assert ['GCCT', 'GCAT', 'T'] == dnas.collect { Dna it -> it.sequence }
  }

  @Test void 'determine highest GC content'() {
    String seq = """>Rosalind_6404
CCTGCGGAAGATCGGCACTAGAATAGCCAGAACCGTTTCTCTGAGGCTTCCGGCCTTCCC
TCCCACTAATAATTCTGAGG
>Rosalind_5959
CCATCGGTAGCGCATCCTTAGTCCAATTAAGTCCCTATCCAGGCGCTCCGCCGAAGGTCT
ATATCCATTTGTCAGCAGACACGC
>Rosalind_0808
CCACCCTCGTGGTATGGCTAGGCATTCAGGAACCGGAGAACGCTTCAGACCAGCCCGGAC
TGGGAACCTGCGGGCAGTAGGTGGAAT"""
    def dnas = Dna.parseFasta(seq)
    dnas.sort(new Dna.ByGcRatioDescComparator())
    assert 'Rosalind_0808' == dnas[0].id
    assert 60.919540d.round(3) == (dnas[0].gcContent() as Double).round(3)
  }

  @Test void 'determing highest GC content (big fasta)'() {
     String seq = """>Rosalind_0702
CTAGGCATTGTACACCTGTGTAGGGATCTGTATGCGGGGCTAGACTATTTGGTCACAGAC
TTCCTCGATTAGGCCGACCGGTCAAAGATTCACAGCCTGCTGACGAAACTGCCGTCAGGG
TGATCGTGCATACCAGAGCCATCTTCGTATCAGCCTCCTTTCCGATGGCTGAGATTGGGT
TTATGGCCTATCACGTGCTAACATAGTACTGGTAAATTAGCACTGCCCAGTAGTAGGAGC
GACTGTAGGTATTATTTGTGAATTCCCCTTTCTCCAAAAAGAGTTTCTACTCTCAGACCT
TGAGGCCTGATGGATAACGAGTATTCACTCAGAGCGTGTCGCCACTTGCCGCCGGTACGA
CAACGTGTAGATTTCGAACATATAGCAGTGTGGAAGTCGCCAGAATGCAGCCTCTTGGAC
CGTTGTATCTTGAGCCGTGGTGATCCGCCTCCAACAGAGGGAAGTTCTACCTTTCACGAC
TCCCCAAGAAGATCCCCGTGGAGTCTTCTCGCTGATGTACCCGATAGTATCAACGCCGAG
CACTGACCCATTCACGGGTGTTGCGGGATGACGAAGTTGGGAAACCCATATCTTGTTGCG
CAGCCCGAAGTCGTCCCTAAAACCGGCTTCCGAGATGCCCTGTACGGTTGCGCCCGGGTT
AGTTAGTGCTGAGACGCTACCGTGTCTCAATTGTATACTCCCAATACCGGTGTATCTTAT
CCTAATCCAGCAGCAAAAGGCTCCCGGGCGCAGAATTCAACGGGTACGTTTGCACAATTT
AGTAAGCTGAAGCGTGTCGAATATGAAAGGTGCACTCTTCGACACCGAAAATTGTGGAAC
GCAGAGCAAAGAGTGAGCGAGATTATCGCCC
>Rosalind_8897
ACCCATTAGCAAGCGTCAATTAACTAGACCGGGCTATCATGCCTCTATGAACATGTCCAC
GGTCCCGGTGATAATAAGATAATCCGACCCAGTGAGGGACGGGGAAGCATCAACGGCGTT
GCTTCCCCTTGGTCGGGTAATCGTACAAAGTGATAACCCTTGCACCGTAAGCACGAGGCG
CGCTCATATGCTGGAAGTTGCCTGGTTTCTCATAGATTCTCAACGCTCACCCGAAGGGAT
CCGGGAGGGTCGAATGAAGTAGCAGTAGTTTGCTTTGCCACGACAGATTGTATGTCTACG
GAGTCCGGTTCCTTACACACAAAGTAACAAGCCTTTACGATCGGTTGTCTCGATAGATTG
AAGTGTTTCTTCTCCCGAAACGCGTTGAGCTCACAGACATAGAGTATCGAGTCGTAGTCA
TAGCAGGTTTTTCGGTAAAGCTTTGGAAGTACCGCTCAACGTGACCTGTGACTTCCGTCG
CCAATGTCGCCCGATACGCCAGCTCGACCGCGTTAGGTGTGGGTTAGGCTATGAAAAAAC
GGTATGGCTCATAACGGGTCGAACAGACCGTGCTTCATCAGATATCGCTGTGTGCACATA
GAGGTAAGTAATTGCGCGCGACGTTCAATACATCCAATCGTTAGACTCGTAGTTTAACCA
TTCTAGCTATGCAGATATCCTATCGTAGTCCGATACAGCACTGAGTATCCCTGGCACGGC
GCGCGCCACGCGTAATTCGTTGGCTTGAGAGTCCCAGCGTCGATACCGCATGAAGTCGCA
CTTAGCATAGTTTGCAACAAGGCCTACGCGCCGCCGGATGTTGTTTCTCGTTGTACGACT
TTCTGACAATCGTCTTTTTAACCTGGATAAGATTTGACGAGCTT
>Rosalind_1070
CGTTGAGTAAGCTGCGATTGGCTTTGAAAAAAGTTCTCCCAGCCCCAGCGCCTTATGCCA
CATGCGGGCTTGCTATTATCCAACACTGTGGGTTCCAACTGCGTGCACATACCTTCAGAA
ATAATTTGGATGTTGAAGGACCTGCCCATGAATTCCCGCCATAGAGGCTCGTCGCACCTA
CCGGGTTTTTTATGTTGATAATTTGCGATGTGACTAGGATATCACTTCGTGGTAGACTAA
ATCGAGGCTTGGACACTTGAAGGACCCGCCGCCCGAACCTCTCCGTGTGCTAATCTCACG
CTAACACTGCCCCTCGTCGTAATAACCCGGGAGTTCCACTAGCAACTGTTGATGGCGCAC
CTACTATCGGACAATGAAATCCCCGAGCATTTTTTAATGTTACTTCAGATGGAGAGTCAC
TCAGAATGCAGGTAACTAGGGGCCCCAATTGATTATTAGTACACCGTATTTTAGGAACGG
CTAGCCGTGTGACCACCCCAAAGTCCCGACGTTTGTTATGCAAGCAACTAAACGTCTGAA
AGAGAATGGGGACGCCAGGCACCTAACTATTCGACAGAAAAGGACCATGCCTTCAAGGGA
CGTTTCTGGGAAGATCTAGCTGCCCACTACATAGGAGTTGCTACCACAAAGCGACTAGTA
GACCCTGGAATTAACTACGAAGACGCCCCAGGGTGGTTGAACCCGAATCCGGTTAAGATT
CGTCGCTAAGAGTGAAATGTGTATAGGGGTAGACACTGTTCGCGGAGGTTCACTGTTAAT
ACGGGATATGATAGCCAATTTTGCCCGTCACCGCACGCCCACGTTCCA
>Rosalind_6830
AGGAGCAACTCTTATGTCCTACTTGCGGCGCGCATACTCGATAAGTTTAGACGGAATGTT
TCTCTGGGTATATAACACGGCCCGGACTGTAAGGTGGAATAAGCCTGTGCAAACCACAAT
GAGGTTTTCCGATGCTACCCGGCGATAATATACACTAGACGGAAGTGAGAGCATGCCATC
GTAGGGAGGTGGTAGCAGTACCATAGCCAGTAAAATGGTTCATGCGGATTCGAGGTCGTG
GGGACCTTTAAGGGTGAGGCTGCGAGTGTTAATGCGCTTTTCAGTAATTGCCGTGGTGTG
ACCTTTGCCAAAGAGAACTCTGACTGAATACGCCCGGATTACAGGGTAGAACCAGTCTGC
GGCATCGTCTTCTGTTCGTTTTGTGGGACAAGCATTACTGGTTTGAGAGATAAAGTAATA
GATCAAACACACTTCACTGGACGCACTCTGCCATCCGCCTAAAGACCATTTGACTCGCCC
ACGGTGTTTAACTCCTTGATACACTATGGCCGGTCTCCCAGAATATACGTTAAGGCTCTG
AGGTCCGGCCTTGGGGACCACCCTCCACGTATAACTTCAGCGACAAGCCCAATGATCTTA
GCTATACTCGTTGCCCAAGGGAGTAAGGAAAATCTCGGATGACTCAGAATCAGCCGTGTG
GCGACCATCAGATAGATCCGACGAGGCCGCTGGGTTTCCGTCGGGCGGTTGCCCCCGATC
CGTGACTACAGTAGGAACACTTGTCTTGACTTGCCAGTCCTCCTGGGGCTCCACTGTTTC
CGATGTCCTTATGGTGTAGTAGGTTCAATACGGTG
>Rosalind_8435
CGTGGCAGAGCACCCATTCCCCTCGTTTGGTGAAAAACGCACCGCCCGTGTAGCATCTAG
TGTGTTTACCTTGTACTGCTTCTATTCAACTGCCCGATAATGGGTGGTGAAGCCATTCAC
GCAAGGCAAGCCCCTTGTATAGTATCACACAGCAAGGGCGAGTTCTCGATACCGAGCTAG
CAGTGCTGAAACCGACTAGTGGATACCCTGATCGAGCGGTCCGCGTATGGAGATGTCCAG
GTCGGACCTTGCATTGAAAGCTTGCCCTGCCCAATATCCGGGTATCAGGGGATATAGCAG
CGATGGGTAGCTACGCCACATAGACAGATACGTGCAATATACAGTGGGGACGCAGTCTTG
TGGTGTCTCTGTTAGTTGCACAGATAATTCGTTCTCAAACACACGACTTATAAAACAGTC
GTGCCTCAGCAAAATACAAAATCCTTGGATGCTTCTCCCTACTGTCACTAGAACGCAGAG
CACCAGCCCCATTCGCCGATATAGAGTTTTGTCGTGAGGCAAGTCACAAATTATTTGACT
CCATTTGGCCTTCTTTTCGCTGTCTAGGTTAAAACCGTGCGGGCTAGGCATCAATTTCCA
CAGTCTTCTGCACTAGCCGATCCCCAGATACCAATTCATTAGTTTATCGTAGACCGTCAC
GTTTGACGTGACCTATAAACCCGTCCTCCACGTAGCTGCAGGCCGCGTGGAGCCGTCGTT
TATCCCCCAGTGGGACAGCGTCCATATTCGGGCAGGGCGCCGCCGCAAGGGTTTCGATAA
TCAAACTTCCGTGGTCGGCCGCAAACGGTGTGCCTTGATAATATTGTACTACTAGCCAAC
CGTACAAGACCTTAGCAGGTCGAGCTCTAGTACGGTGGACGCGTAATGATCATCCGACTT
GACCTTTAATCAAATCAAGGCCACTGTCAAGCCAATGCACTCTGTATTAGCCATGATCTA
ACGGACGAGTGCCGGCGA
>Rosalind_9397
GTCCATTCCTCCGACCAGGTATGTAGTTCCTAGAGTTAGATAGTGCTCAGACTAGTAAAA
TGTGGGTATCAAATTAACCCTGGGACCCGCGAGCGGAAATCGATGTTATGGCTATTCTGC
GAATCATGAGAACTGTTTATAGCTTGAACTTTTAGAGAAGCCCGTATAGGCTGCTTCAAG
ATACGGTGTGCTTGCCTGGAGATTCGGCCGAGAACTTGTCCAATTATGCCTTATTCTCTA
CAGTCCGGAGTTAGATTTGGACATCCTTCTGCAACGCAGGTCGGATTCAACTGACCCGTC
GGTCTACACCGGCAAAACTCCTTCGCACAAAGGGCAAGTCCAGCTGGTAGTCCGTGTGAT
TCTTTGGAACTTATGAGCAACTATCCTATATTTGATCCGTCACATCAGGTGGTCGGTTCG
ACCGTCGACCAAGCAGGCGGGCCACTGCACTTCCAACCTTCAATTTCACGTTTGTTAACA
ATGTCTTGCTTGCTTCCGCTGCCAACCCTGTAAACTCCCGACTTACCTGAATTTCCGTGG
CCATTCTGCTATCCGGCTACTCGGAGCGGCTAAGTGCACCATCGTACGATAGGTGGTTTC
GTATCCGCGAAAGAGAAGTCGAAGACTAAGCGTCGCGACTGCTGGGGATCCCGAGCAGTC
TACCGATGCTTAATCTGTTCAACCAGCAGTTTCCTCTTTGTGACCTCTACTCTCAGCAGG
GCTCGTTTCGTGGTAGCCACGAAACTTATTGATTGTGCACTTTCTTGCTTTCGATTCACT
CATGTAGAGCATGAAAACCGACAGCAATTTTGCAAAGGCTGTGCTGGTTACATATGGGCT
TGAACCACTACCCTGTCTCACAGGCTTTTGCAAAGGCGGCCAATTTACAATCTCTAGCAA
GCTCTAAAAACTTCTAAGCAGACCAGCAGCTGGCCATTGGACCAGCCGAATTTATCCTAC
AAGGGACGTGAGGGTGATTTG
>Rosalind_9350
CGGCTCGCTACGGTTATCCATCGCACCACAGCGCTTCTGATCGCTTTTGTGCCCTGAAGG
TTTATCCAATCTAAATCTACAGACTGTGTTGGCGGTTAGACGGGGTCGAAGGCCGCCGTG
AAGCTGATAGGTGCACATTGATTTTTGTCGTCCAAGTAGTCCTTATACTCATACTTTATG
TTTATTGAGTGCGCCTTTCAGTGAGGGAACTGACCGGGCGCACCACGTGGGGTAGCTCTC
AACGGGAGTAGGAGCTCTAGTGCACCATTCCTATAAAGACAGAGAATTGGTGAATAGCCC
CAGCAAAGCTCTTCGTACCAAGAAAGGACGAACGGGCGTAGACAGCACTCTCCCTGAGGA
GATATCCTATGGTTAAAGTTTTGAATATACACCTGTGAGCGGGAGCTAACTTGTTTTGGA
AGCATTTCTGAGTGTATATCACCTGGTGTAATCGTTTTGGTCCGCGCACTGGTGTTGGAG
GGGGCTTGACCTAGAGCCAAGTCCGGGGATAGGGTTGGACCAAGCGCTAGGAATTATTTT
GGCCGCGATTACATACACATCTTGCAGCCTTAGACAGTGACTGTATCAATCCGACGGTGT
TCACGGCGTTAATAGCAGCAGCACATCGTAGCTAATGTCATACCCTCAAGACAGAGCTTA
GCGAGGTGTTAAGGCGCCGACACCCATCAGTTCTGGATTGGTGTGCCACGTTACAGAGAA
GTCACTCAAGGATCTATTTCGTTACAGTCAACTGTGATTTACATAAGTAAATGCGTCCTC
CATTCGCCTTCTGATACAGACGAATTCGGCTGCGTTGAGCTACGGCCTAGCAACCGTACT
ACGAGGGGCGCTTACTCAATCCTCGCTG
"""
    def dnas = Dna.parseFasta(seq)
    dnas.sort(new Dna.ByGcRatioDescComparator())
    assert 'Rosalind_0702' == dnas[0].id
    assert 50.976d.round(3) == (dnas[0].gcContent() as Double).round(3)
  }

  final static Map<String, String> BIG_MOTIF_SEQ =
      [sequence   : 'ATTCCCCATTCCCCGTGGGGTACCATTCCCCCTATTCCCCTTATCTATTCCCCGCATTCCCCATTCCCCATTCCCCCTTATTCCCCGTTAGAATTCCCC' +
          'ATTCCCCTGATTCCCCATTCCCCTTGATTCCCCGAATTCCCCTACAGATTCCCCATTTTGTTTTATTCCCCTGGTATTCCCCGCATTCCCCCGTGATTCCCCCCGA' +
          'TTCCCCTCATTCCCCTAGTGATTCCCCAATTCCCCGATTCCCCTACAATTCCCCATTCCCCATTCCCCTATTCCCCCAATTCCCCCATTCCCCTATTCCCCATTCC' +
          'CCTACATTCCCCACTCATTCCCCATCATTCCCCATTCCCCCAATTCCCCTCTATTCCCCAAATATTATATTCCCCATTCCCCTCAGGGATTCCCCATTCCCCGAGA' +
          'TTCCCCATTCCCCATTCCCCACAATTCCCCATTCCCCGCACGCATTCCCCATTCCCCCACGGATTCCCCGATTCCCCGTGTTATTCCCCATTCCCCCGTATTCCCC' +
          'AATTCCCCCAATTCCCCATTCCCCCTATTCCCCTAGATATTCCCCCATTCCCCATTCCCCATTCCCCTATTCCCCTTTCTGCTGTAGATTCCCCATTCATTCCCCA' +
          'TTCCCCCCGAAATTCCCCTGATTCCCCATTCCCCGTTGCCATTCCCCTATTCCCCATCGATTCCCCTATTCCCCGGCGATTCCCCATTATTCCCCATATTCCCCGA' +
          'TTCCCCCATTCCCCCCATCTCTATTCCCCTATTCCCCATTCCCCTTGCCTAGATTCAGATTCCCCGGTAGAATTCCCCAATTCCCC',
       subsequence: 'ATTCCCCAT']
  final static Map<String, String> LONGEST_COMMON_SEQ1 = [
      fasta           : '>Rosalind_1\n' +
          'GATTACA\n' +
          '>Rosalind_2\n' +
          'TAGACCA\n' +
          '>Rosalind_3\n' +
          'ATACA',
      longestCommonSeq: 'TA'
  ]
  final static Map<String, String> LONGEST_COMMON_SEQ2 = [
      fasta           : DnaTest.class.getResource('/longest_common_seq_big.fasta').text,
      longestCommonSeq: 'CTTAGTTAATTACACCCGCAATCTTCCGATTATCCGTACGGGTGTATCGGAGAGCTGGAATGTGACCCTGTGAGTCGCGCCTCACGTAAA' +
          'CGCATGACTGTCGGGTACAGCATCTGCGCCCCACCTCTACAGTAAATGTGGAGATTCGGTAGCTGCAATGCCAAATAGGAAC'
  ]
  final static Map ORF1 = [
      fasta   : '>Rosalind_99\n' +
          'AGCCATGTAGCTAACTCAGGTTACATGGGGATGACCCCGCGACTTGGATTAGAGTCTCTTTTGGAATAAGCCTGAATGATCCGAGTAGCATCTCAG',
      proteins: ['M', 'MGMTPRLGLESLLE', 'MTPRLGLESLLE', 'MLLGSFRLIPKETLIQVAGSSPCNLS']
  ]
  final static Map ORF2 = [
      fasta: '>Rosalind_8288\n' +
          'TCCCTCCAGTTGGAAGACTTGAATAACGCACTATTATCCTTGATTCCCAACATAGGCTAA\n' +
          'ACCTCCGAAACATAGGTTGAGCGATGGCCGTTGGATGACTTGAGGAGATATGATTCGCGC\n' +
          'GTAGACTATCTGCCAATTGGGAACATAAGAAAGATACAGATGTATTGATGGCCACATATG\n' +
          'TCATTTTATTTCAACGCGCCACATCGAACTGCGTGGCCACTATATAAGACGTCCGTGGCC\n' +
          'TTAACCACCTAACGTTATGTTATCCCAGTAGGTGGGGTGTGGATATGACGCCAGGAACTA\n' +
          'CTTTAGGAACCGACGTCCACAGGTCCTCCTTTAGTCTGTGTAATGTCTCACCTGCGCGCG\n' +
          'CCGGATGAGGACAAACGATTCAACGAACATCCTTGATGATATTGCATTACGCTGAGCTCG\n' +
          'GTGCGTACCGATTGGGTGAAATATCTATTTATACGACCCGGAAACCAGGTCGATGATGGT\n' +
          'GTTCTCGGTTCACTAGCTAGTGAACCGAGAACACCATATGAGAATGCCCGACACACCTGG\n' +
          'GAAGGCATTTGAATTTCACCCGGTCCGCTAGGGCGAGTGGAGTAGAAAGCGCTGGCCTTA\n' +
          'TGGTAGCCTTGCTACTTGACGTTTATAACAAAGGAAACGACAGTCTTCGACTTCCTAACG\n' +
          'TTACCACCACTGCCTCATCTCCTGAGATTGCTCCGCTCTAACGAGTTTGGTATAGCCGAG\n' +
          'CCGCGACAGCTTGGTGTGACGATGAGAAGCTGGAGAACCTAATCTTCGCGGCGCTAAACA\n' +
          'CAGCGTTTCTGGTGAGGTAATAACGATTCAATGCCGAGTAGGGACCCACCTTTAACGGTA\n' +
          'TAAGGTACTTTAAATTGGACCTTTTAGGCCGACGAATTATTCTGCGAGGACAGTTCTTTT\n' +
          'GACACCAAGGTCGAGATATGTACTGCACCTGCCTAAATGCGACGGTTAAGTCAGGGTAGA\n' +
          'CGGTACCCTTTCTCTCGCATCACCTGCTATAA',
      proteints: ['MAVG', 'MT', 'MIRA', 'MY', 'MATYVILFQRATSNCVATI', 'MSFYFNAPHRTAWPLYKTSVALTT', 'MLSQ',
                  'MTPGTTLGTDVHRSSFSLCNVSPARAG', 'MSHLRAPDEDKRFNEHP', 'MRTNDSTNILDDIALR', 'MILHYAELGAYRLGEISIYTTRKPGR',
                  'MMVFSVH', 'MVFSVH', 'MRMPDTPGKAFEFHPVR', 'MPDTPGKAFEFHPVR', 'MVALLLDVYNKGNDSLRLPNVTTTASSPEIAPL',
                  'MRSWRT', 'MPSRDPPLTV', 'MYCTCLNATVKSG', 'MREKGYRLP', 'MRQWW',
                  'MPSQVCRAFSYGVLGSLASEPRTPSSTWFPGRINRYFTQSVRTELSVMQYHQGCSLNRLSSSGARR', 'MQYHQGCSLNRLSSSGARR',
                  'MFVESFVLIRRAQVRHYTD', 'MWRVEIK', 'MWPSIHLYLSYVPNWQIVYARIISPQVIQRPSLNLCFGGLAYVGNQG', 'MFPIGR']
  ]
  final static Map SPLICING1 = [
      originalFasta: '>Rosalind_10\n' +
          'ATGGTCTACATAGCTGACAAACAGCACGTAGCAATCGGTCGAATCTCGAGAGGCATATGGTCACATGATCGGTCGAGCGTGTTTCAAAGTTTGCGCCTAG',
      introns: '>Rosalind_12\n' +
          'ATCGGTCGAA\n' +
          '>Rosalind_15\n' +
          'ATCGGTCGAGCGTGT',
      resultingProtein: 'MVYIADKQHVASREAYGHMFKVCA'
  ]
  final static Map SPLICING2 = [
      originalFasta: '>Rosalind_8849\n' +
          'ATGACTGGACGTAACACTGGACCAGTGTCCATCCGTGCGACGGTAGTCCGAAAACGATTT\n' +
          'AACACAGGAAAGTTATCTTACTACGTTTATTGCTGGATTTAGATAGAGTCCGCCCCTAAA\n' +
          'CTCTGTGAAATGGTTGGCGTGCCACGGCCGACTCTTCTGTCTGTCTTTCTCTTACACTTA\n' +
          'TTGTCGCATTTCCTTCAGAAAACATGACAATATATGATTACATCGCCGCTGCAACGAACA\n' +
          'GGGATATTGGGGAGAGTCTTGGTTCCCTTGGTGCAGGATTTTTAACCGTGGTAGGTGACT\n' +
          'CGGGACTTAAACGCGTGCTCTGTCGTGAAAACCTTGATTTTGCTAAGATTTTGGGGGTAC\n' +
          'CGCCGTGGCCCCCAAGCTGTGTCAACAAAAAATGTGTTAGACTCTCCGCTCCACGACATA\n' +
          'CCGTGGGAAAGATTGTATCTGAAGCCGGACACCTGGTGGTGCCAAGGTAAACTACCTGAC\n' +
          'GCTTTGGTCGAGAGAACATCGCGTATTTCGCCGCCAACACTTCTAGTGAGCACTTTGGTG\n' +
          'TGCTTGATACTTTACGAAATAAGTTTCGGGACTTCGAGATATGGATCATCGTAGGGGCGT\n' +
          'GCCAAAGGATTGTACGCCAAGACCATCCCTCGAGCTACATTATCGGAATGTATAAAATTT\n' +
          'GGCCTACCAGCGTCTGACATATCTCGTCTTTAATTCAGTTGCTAGTGTTCTCGGAGTAAC\n' +
          'TAACCGTACACACATTGCGCAGTCGAGATTCGGATGGAACTAGGCTGAGAACGCTAGTGG\n' +
          'TACTTCGCTTCCTCCAAGGGTGCTGTATTCCTCTCGGCGTGTGGCACTGAGTATTCTGTT\n' +
          'CGAGATGACGAAATCTACCAAACTGTAATATTCCTCCATTGTAGATCTAAGGTATGGTGC\n' +
          'TTAACGTCTCATACTCTGCGTGCTAG',
      introns: '>Rosalind_2952\n' +
          'GCTAGTGTTCTCGGAGTAACTAACCGTACA\n' +
          '>Rosalind_0885\n' +
          'ATTGTACGCCAAGACCATCCCTCGAGCTACATTATCGGAATGTATAAAAT\n' +
          '>Rosalind_0793\n' +
          'GTCGCATTTCCTTCAGAAAACATGACAATA\n' +
          '>Rosalind_9671\n' +
          'AAGATTTTGGGGGTACCGCCGTGG\n' +
          '>Rosalind_6957\n' +
          'GGTGCAGGATTTTTA\n' +
          '>Rosalind_8138\n' +
          'CGTGCGACGGTAGTCCGAAAACGATTTAACACAGGAAAGTTATCTTAC\n' +
          '>Rosalind_9970\n' +
          'GGTGTGCTTGATACTTTACGAAATAAGTTTCGGGACTTC\n' +
          '>Rosalind_2454\n' +
          'AACTAGGCTGAGA\n' +
          '>Rosalind_0551\n' +
          'CTCGGCGTGTGGCACTGAGTATTCT\n' +
          '>Rosalind_5621\n' +
          'ATTTAGATAGAGTCCGCCCCTAAACTCTGTGAAATGGTTGGCGT\n' +
          '>Rosalind_1771\n' +
          'ACCGTGGGAAAGATTGTATCTGAAGCCGGACACCTGGTGGT\n' +
          '>Rosalind_4854\n' +
          'AGATCTAAGGT\n' +
          '>Rosalind_6916\n' +
          'TCGAGAGAACATCGCGTATTTC',
      resultingProtein: 'MTGRNTGPVSIYVYCWATADSSVCLSLTLIYDYIAAATNRDIGESLGSLTVVGDSGLKRVLCRENLDFAPPSCVNKKCVRLSAPRHAKVNYL' +
          'TLWAANTSSEHFEIWIIVGACQRLAYQRLTYLVFNSVHIAQSRFGWTLVVLRFLQGCCIPVRDDEIYQTVIFLHCMVLNVSYSAC'
  ]
  static final Map PALINDROME1 = [
      fasta      : '>Rosalind_2584\n' +
          'GCGCAAGTTCATTGACCGCTTTTTGGTTGTAAAGAGCATAATAAGACCTCCTAAAAACAT\n' +
          'ATACATACAGCTTACTTGTCCTACTAAGGTACTAAGTCAAGGGACTACATCCGGTCCTTA\n' +
          'CTCCTTAATTCATAGAAGGTCTTTCCCCTTTTATGCCAAAGATAGTGTTAAGACCAGCCT\n' +
          'TAACGTTTGTATCAAGGTAGTCTTGTGACGAGGTCTGGCCTGTAACGCTGGCTGCTTCAG\n' +
          'TTAGCCAAGAAAACCCATGCTAGTGAATAAAAACGCTGTTCACACCGCAGGGAATTTATT\n' +
          'ACGGCGTTCCAGGAAACTGCGAGTTTCGTCGGAACGTGTCCGATCAAGTACACGGTTATT\n' +
          'ATGCTGTTGCGTCACTTTGGAGATAACCCATGCCGGGATGGACGACTATCATATGAGTGA\n' +
          'GCGAGTAGTTGCCCTAGAGAGTCACGTGACATGAACCGACCCTGAACACTTAGATAGGGC\n' +
          'CCTATGTTAGCATGGCCCAATAATTGGAATGGTATCCGTCCGTCCTCGTTTGACAGTCTC\n' +
          'GCTTGGCCATGCTTGAAAAAGACGTCAACGAGGGTTCCGAACTCGTACTTCGGGCGTGAG\n' +
          'CCGATCAAGGGACCTTATCTATAGTGACTAGGCTCTTTCATACGCCGCATACCCGGCCCC\n' +
          'CGGTGTGACCAGTTTTCTCAAAGATGCATCACAATGGTCGGTGCGCATGGCGAATCTCCA\n' +
          'AAAGCCCTCAAACTATCGCGATCAAAGCGACGCCAGGATTCGCGATTGATTGAGTAGCAG\n' +
          'GCTGTGCCAGGACTTTCAAGCATAACTTTACGAGCATTACGTGATCTCACTACCAGCGAG\n' +
          'CATTAACGGTAATGGTGATCAGAGACGATGACCTCTGCTTGACCTTGTAGTCAGTCAGTG\n' +
          'ATACAGACACTTCTGGTCACCCTGCAGACAACAAGACAAGTGTCCGAACCCCCGATAT',
      palindromes: [(1)  : 4,
                    (59) : 4,
                    (60) : 4,
                    (69) : 4,
                    (89) : 4,
                    (111): 4,
                    (125): 4,
                    (127): 4,
                    (168): 4,
                    (180): 4,
                    (182): 6,
                    (183): 4,
                    (217): 4,
                    (256): 4,
                    (260): 4,
                    (293): 4,
                    (334): 4,
                    (342): 4,
                    (348): 4,
                    (389): 4,
                    (393): 4,
                    (409): 8,
                    (410): 6,
                    (411): 4,
                    (434): 4,
                    (441): 10,
                    (442): 8,
                    (443): 6,
                    (444): 4,
                    (450): 4,
                    (474): 12,
                    (475): 10,
                    (476): 8,
                    (477): 6,
                    (478): 4,
                    (491): 4,
                    (494): 4,
                    (502): 4,
                    (544): 6,
                    (545): 4,
                    (548): 4,
                    (561): 6,
                    (562): 4,
                    (585): 4,
                    (603): 4,
                    (619): 6,
                    (620): 4,
                    (628): 4,
                    (653): 4,
                    (655): 4,
                    (660): 4,
                    (683): 8,
                    (684): 6,
                    (685): 4,
                    (702): 6,
                    (703): 4,
                    (706): 4,
                    (735): 8,
                    (736): 6,
                    (737): 4,
                    (740): 4,
                    (760): 6,
                    (761): 4,
                    (819): 4,
                    (823): 4,
                    (843): 4,
                    (856): 6,
                    (857): 4,
                    (922): 6,
                    (923): 4,
                    (955): 4]


  ]
}
